package com.example.rssivalidation

import android.annotation.SuppressLint
import android.bluetooth.BluetoothAdapter
import android.bluetooth.BluetoothManager
import android.bluetooth.le.ScanCallback
import android.bluetooth.le.ScanFilter
import android.bluetooth.le.ScanResult
import android.bluetooth.le.ScanSettings
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Binder
import android.os.Build
import android.os.IBinder
import android.util.Log
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModelProvider
import com.aptener.bluconnect.BluArmorGattListener
import com.aptener.bluconnect.BluConnectService
import com.aptener.bluconnect.app.device.sx.proto.FirmwareResponseOuterClass
import com.aptener.bluconnect.client.ConnectionState
import com.aptener.bluconnect.common.SimpleName
import com.aptener.bluconnect.common.ext.asMutableStateFlow
import com.aptener.bluconnect.device.AdvertisingBluArmorDevice
import com.aptener.bluconnect.device.BluArmorDevice
import com.aptener.bluconnect.device.BluArmorModel
import com.aptener.bluconnect.device.C30
import com.aptener.bluconnect.device.NoDevice
import com.aptener.bluconnect.device.sxcontrol.DeviceInfo
import com.aptener.bluconnect.device.sxcontrol.RideGrid
import com.example.rssivalidation.Extensions.asMutableLiveData
import com.example.rssivalidation.NotifyDeviceState.Companion.NOTIFICATION_ACTION
import com.example.rssivalidation.NotifyDeviceState.Companion.NOTIFICATION_ACTION_EXIT
import com.example.rssivalidation.NotifyDeviceState.Companion.NOTIFICATION_ACTION_KEY
import com.google.protobuf.ByteString
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import timber.log.Timber
import java.util.regex.Pattern
import kotlin.system.exitProcess

class SerivcesBle: BluConnectService() {
    private val notificationDeviceState = NotifyDeviceState()
    var device: C30? = null
    val deviceInfo: StateFlow<DeviceInfo.DeviceDetails?> = MutableStateFlow(null)
    val activeDevice: StateFlow<BluArmorDevice> = MutableStateFlow(NoDevice)
    private val _deviceInfoData = MutableLiveData<Map<String, String>>()
    val connectionState: StateFlow<ConnectionState> = MutableStateFlow(ConnectionState.Discovery)
    val ridegridMacAddress: StateFlow<String> = MutableStateFlow("Unknown")
    val rideGridRiders: LiveData<List<RideGridUserDetails>> = MutableLiveData()
    val rideGridState: StateFlow<RideGrid.RideGridState> =
        MutableStateFlow(RideGrid.RideGridState.OFF)
    val RIDEGRID_MAC_ADDRESS= "EF:AE:89:F9:B8:83"
    var rssiRidegrid: Int = -1000
    lateinit var leScanCallback: ScanCallback


    private lateinit var viewModel: BleViewModel
//private val viewModel: BleViewModel by

    private val bluetoothAdapter: BluetoothAdapter by lazy {
        val bluetoothManager = getSystemService(Context.BLUETOOTH_SERVICE) as BluetoothManager
        bluetoothManager.adapter
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        if (intent?.action == NOTIFICATION_ACTION && intent.extras?.getString(
                NOTIFICATION_ACTION_KEY
            ) == NOTIFICATION_ACTION_EXIT
        ) {
            stopForeground(true)
            exitProcess(9)
        }
        return super.onStartCommand(intent, flags, startId)
    }

    @SuppressLint("ForegroundServiceType")
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate() {
        super.onCreate()
        Log.e("Serrvice Started", "Started")
        startForeground(
            NotifyDeviceState.NOTIFICATION_ID,
            notificationDeviceState.getNotificationBuilder(applicationContext).build()
        )
        viewModel = ViewModelProvider.AndroidViewModelFactory.getInstance(application)
            .create(BleViewModel::class.java)
    }

    private val binder = BluServiceBinder()
    override fun onBind(intent: Intent): IBinder = binder
    override fun onBluArmorDeviceDiscovered(result: Set<AdvertisingBluArmorDevice>) {
    }

    private fun rideGridObserver(rideGridState: RideGrid.RideGridState) {
        if (rideGridState == RideGrid.RideGridState.OFF) rideGridRiders.asMutableLiveData()?.value =
            emptyList()
        this.rideGridState.asMutableStateFlow()?.tryEmit(rideGridState)
    }

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onConnectionStateChange(state: ConnectionState) {
        connectionState.asMutableStateFlow()?.tryEmit(state)
        when (state) {
            is ConnectionState.Connected -> Unit
            is ConnectionState.Connecting -> Unit
            is ConnectionState.DeviceReady -> {
                when (state.device.model) {
                    BluArmorModel.C30 -> onDeviceReady(state.device as C30)
                    BluArmorModel.S10X -> TODO()
                    BluArmorModel.S10X_OTA -> TODO()
                    BluArmorModel.S20X -> TODO()
                    BluArmorModel.S20X_OTA -> TODO()
                    BluArmorModel.C30_OTA -> Unit
                    BluArmorModel.H30 -> TODO()
                    BluArmorModel.H30_OTA -> TODO()
                    BluArmorModel.AH -> TODO()
                    BluArmorModel.AH_OTA -> TODO()
                    BluArmorModel.NO_DEVICE -> TODO()
                    BluArmorModel.OBEX -> TODO()
                    BluArmorModel.OBEX_OTA -> TODO()
                    BluArmorModel.MWX1 ->onDeviceReady(state.device as C30)
                    BluArmorModel.MWX1_OTA -> TODO()
                }
            }
            ConnectionState.Discovery, is ConnectionState.Disconnecting, is ConnectionState.Failed,
            is ConnectionState.ScannerNotReady -> Unit
        }
    }

    @SuppressLint("MissingPermission")
    private fun onDeviceReady(c30: C30) {
        viewModel = ViewModelProvider.AndroidViewModelFactory.getInstance(application)
            .create(BleViewModel::class.java)

        Timber.e("")
        activeDevice.asMutableStateFlow()?.tryEmit(c30)
        device = c30
        try {
            applicationContext.unregisterReceiver(receive)
        } catch (_: Exception) {

        } finally {
//            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU){
//                applicationContext.registerReceiver(receive, IntentFilter().also{
//                    it.addAction(BluArmorGattListener.ACTION_GATT)
//                }, RECEIVER_EXPORTED)
//            }
//            else{
                applicationContext.registerReceiver(receive, IntentFilter().also{
                    it.addAction(BluArmorGattListener.ACTION_GATT)
                })
//            }
        }
        c30.deviceInfo.observe(this::deviceInfoObserver)
        Log.d("Device Name", "${c30.deviceInfo.SimpleName}")
//        c30.rideGrid.turnOn()
//        val scanFilter: List<ScanFilter> = listOf(ScanFilter.Builder()
//            .setDeviceAddress(RIDEGRID_MAC_ADDRESS).build())
//        val scanSettings = ScanSettings.Builder().setScanMode(SCAN_MODE_LOW_POWER).build()
//        startBleScanner(scanFilters = scanFilter, scanSettings = scanSettings)
////        Timer().schedule(10*1000){
//            stopBleScanner()
//            c30.rideGrid.turnOff()
//        }
        c30.rideGrid.observe(this::rideGridObserver)
    }

    private fun deviceInfoObserver(deviceDetails: DeviceInfo.DeviceDetails?) {
        this.deviceInfo.asMutableStateFlow()?.tryEmit(deviceDetails)
        deviceDetails ?: return
        val deviceInfoDataToSend2 = mapOf<String, String>(
            "srNumber" to (deviceDetails.srNo),
            "macAddress" to (deviceDetails.macAddress)
        )
        _deviceInfoData.value = deviceInfoDataToSend2
    }

    inner class BluServiceBinder : Binder() {
        val service
            get() = this@SerivcesBle
    }

    private val receive = object : BroadcastReceiver() {
        @SuppressLint("MissingPermission")
        override fun onReceive(context: Context?, intent: Intent?) {
//            Log.d("Received Details", "${intent?.extras?.keySet()?.joinToString(", ") { it.toString() }}")
            when (intent?.extras?.getInt(BluArmorGattListener.KEY_GATT_ACTION_TYPE)) {
                BluArmorGattListener.GATT_READ -> Unit
                BluArmorGattListener.GATT_WRITE -> Unit
                BluArmorGattListener.GATT_NOTIFICATION -> {
                    val data: ByteArray? =
                        intent.extras?.getByteArray(BluArmorGattListener.KEY_GATT_DATA)
                    if (data != null) {
                        try {
                            val firmwareResponse: FirmwareResponseOuterClass.FirmwareResponse? =
                                FirmwareResponseOuterClass.FirmwareResponse.parseFrom(data)
                            if (firmwareResponse != null) {
                                when (firmwareResponse.firmwareResponse) {
                                    FirmwareResponseOuterClass.FirmwareResponse.FirmwareResponseType.RIDEGRID_RES -> {
                                        if (firmwareResponse.rideGridResponse.rideGridClusterInfoResponse.self) {
                                            firmwareResponse.rideGridResponse.rideGridClusterInfoResponse.node.macAddress
                                            Log.d("Ridegrid_mac_address: ", "${firmwareResponse.rideGridResponse.rideGridClusterInfoResponse.node.macAddress}")
                                            ridegridMacAddress.asMutableStateFlow()?.tryEmit(
                                                reverseMACAddress(
                                                    macByteStringToString(
                                                        firmwareResponse.rideGridResponse.rideGridClusterInfoResponse.node.macAddress
                                                    )
                                                )
                                            )
                                            Log.d("Reverse: ", "${reverseMACAddress(macByteStringToString(firmwareResponse.rideGridResponse.rideGridClusterInfoResponse.node.macAddress))}")
                                        }
                                    }
                                    else -> Unit
                                }
                            }
                        } catch (e: Exception) {
                            Log.d("Error: ", " FW Error")
                        }
                    } else throw IllegalArgumentException("Null data")
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

    @SuppressLint("MissingPermission")
    fun startBleScanner(scanFilters: List<ScanFilter>, scanSettings: ScanSettings) {
        Log.d("ridegridMacAddress BLE scanner", "${ridegridMacAddress}")
        leScanCallback = object : ScanCallback() {
            override fun onScanResult(callbackType: Int, result: ScanResult) {
                super.onScanResult(callbackType, result)
                Log.d("Service_RG_MacAddress", "${result.device.address}")
                if (ridegridMacAddress != null) {
                    Log.d("Service_RideGrid RSSI","${result.rssi} rideGrid RSSI ${rssiRidegrid} ")
                    if (rssiRidegrid < result.rssi) {
                        rssiRidegrid = result.rssi
                        Log.d("Data RSSI_From_result:", "${rssiRidegrid}")
                        val range = 0 ..5
                        if (range.contains(rssiRidegrid)){
                            Log.d("Test Scenario Pass", "PASSED")
                            Toast.makeText(this@SerivcesBle, "PASS", Toast.LENGTH_SHORT).show()
                        }
                        else{
                            Log.d("Test Scenario Fail", "FAILED")
                            Toast.makeText(this@SerivcesBle, "FAIL", Toast.LENGTH_SHORT).show()
                        }
                    }
                        }else{
                            rssiRidegrid = result.rssi
                        }
                }
            }
            bluetoothAdapter.bluetoothLeScanner.startScan(scanFilters, scanSettings, leScanCallback)
        }

    @SuppressLint("MissingPermission")
    fun stopBleScanner(){
        bluetoothAdapter.bluetoothLeScanner.stopScan(leScanCallback)
    }
}

