package com.example.rssivalidation

import android.annotation.SuppressLint
import android.bluetooth.BluetoothAdapter
import android.bluetooth.le.ScanFilter
import android.bluetooth.le.ScanSettings
import android.content.BroadcastReceiver
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.content.ServiceConnection
import android.os.Bundle
import android.os.IBinder
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.aptener.bluconnect.BluArmorGattListener
import com.aptener.bluconnect.app.device.sx.proto.FirmwareResponseOuterClass
import com.aptener.bluconnect.common.ext.asMutableStateFlow
import com.example.rssivalidation.ui.theme.RssiValidationTheme
import com.google.protobuf.ByteString
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import java.util.regex.Pattern


class MainActivity : ComponentActivity(), ServiceConnection {
    private val bluService: StateFlow<SerivcesBle?> = MutableStateFlow(null)
    private val viewModel: BleViewModel by viewModels()
    private lateinit var bleScanner: BleScannerClass
    val scanFilter: List<ScanFilter> = listOf(
        ScanFilter.Builder()
            .setDeviceAddress(bluService.value?.RIDEGRID_MAC_ADDRESS).build()
    )
    val scanSettings = ScanSettings.Builder().setScanMode(ScanSettings.SCAN_MODE_LOW_POWER).build()

    @SuppressLint("CoroutineCreationDuringComposition", "StateFlowValueCalledInComposition")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        try {
            applicationContext.unregisterReceiver(receive)
        } catch (_: Exception) {

        } finally {
            applicationContext.registerReceiver(receive, IntentFilter().also {
                it.addAction(BluArmorGattListener.ACTION_GATT)
            })
        }

        setContent {
            RssiValidationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BleScreen(viewModel = viewModel, mainActivity = this)
                }
            }
        }
    }

    override fun onStart() {
        super.onStart()
        Intent(this, SerivcesBle::class.java).also { intent ->
            bindService(intent, this, Context.BIND_AUTO_CREATE)
        }
    }

    @SuppressLint("MissingPermission")
    override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
        val binder = service as SerivcesBle.BluServiceBinder
        bluService.asMutableStateFlow()?.tryEmit(binder.service)
    }

    override fun onServiceDisconnected(name: ComponentName?) {
        bluService.asMutableStateFlow()?.tryEmit(null)
    }

    private val receive = object : BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent?) {
            when (intent?.extras?.getInt(BluArmorGattListener.KEY_GATT_ACTION_TYPE)) {
                BluArmorGattListener.GATT_READ -> Unit
                BluArmorGattListener.GATT_WRITE -> Unit
                BluArmorGattListener.GATT_NOTIFICATION -> {
                    val data: ByteArray? =
                        intent.extras?.getByteArray(BluArmorGattListener.KEY_GATT_DATA)
                    if (data != null) {
                        try {
                            val firmwareResponse =
                                FirmwareResponseOuterClass.FirmwareResponse.parseFrom(data)
                            if (firmwareResponse != null) {
                                when (firmwareResponse.firmwareResponse) {
                                    FirmwareResponseOuterClass.FirmwareResponse.FirmwareResponseType.RIDEGRID_RES -> {
                                        if (firmwareResponse.rideGridResponse.rideGridClusterInfoResponse.self) {
                                            val macAddress =
                                                reverseMACAddress(
                                                    macByteStringToString(
                                                        firmwareResponse.rideGridResponse.rideGridClusterInfoResponse.node.macAddress
                                                    )
                                                )
                                            Log.d(
                                                "Activity_mac_address: ",
                                                "${firmwareResponse.rideGridResponse.rideGridClusterInfoResponse.node.macAddress}"
                                            )
                                            viewModel.setRidegridMacAddress(macAddress)
//                                            Log.d("First_push","${viewModel.setRidegridMacAddress(macAddress)}")
                                        }
                                    }
                                    else -> Unit
                                }
                            }
                        } catch (e: Exception) {
                        }
                    } else {
                    }
                }
            }
        }
    }

    fun reverseMACAddress(str: String?): String {
        val pattern: Pattern = Pattern.compile(":")
        val temp: Array<String> = pattern.split(str)
        var result = ""
        for (i in temp.indices) {
            result = if (i == temp.size - 1) temp[i] + result else ":" + temp[i] + result
        }
        return result
    }

    fun macByteStringToString(macAddress: ByteString): String {
        if (macAddress.count() != 6)
            throw IllegalArgumentException("Invalid MAC address!")
        return macAddress.joinToString(":") { "%02x".format(it) }.uppercase()
    }

    fun startBleScanner() {
        val scanFilters: List<ScanFilter> = scanFilter
        val scanSettings: ScanSettings = scanSettings

        val bluetoothAdapter = BluetoothAdapter.getDefaultAdapter()
        bleScanner = BleScannerClass(viewModel, bluetoothAdapter)

        bluService.value?.device?.rideGrid?.turnOn()
        bleScanner.startBleScanner(scanFilters, scanSettings)
       Log.d("Size of data","${bleScanner.scanResults.size}")
    }

    fun stopBleScanner() {
        bleScanner.stopBleScanner()
        bluService.value?.device?.rideGrid?.turnOff()
    }
}