package com.example.rssivalidation

import android.annotation.SuppressLint
import android.bluetooth.BluetoothAdapter
import android.bluetooth.le.ScanCallback
import android.bluetooth.le.ScanFilter
import android.bluetooth.le.ScanResult
import android.bluetooth.le.ScanSettings
import android.util.Log

@SuppressLint("MissingPermission")
class BleScannerClass(
    private val viewModel: BleViewModel,
    private val bluetoothAdapter: BluetoothAdapter

) {
    private val scanResults: MutableList<ScanResult> = mutableListOf()
    private var leScanCallback: ScanCallback? = null
    var rssiRidegrid: Int = -0
    val ridegriMac = viewModel._ridegridMacAddress.value.toString()

    fun startBleScanner(scanFilters: List<ScanFilter>, scanSettings: ScanSettings) {
        leScanCallback = object : ScanCallback() {
            override fun onScanResult(callbackType: Int, result: ScanResult) {
                super.onScanResult(callbackType, result)
                if (result.device.address == "EF:AE:89:F9:B8:83") {
                    Log.d("transcipt", "${result.scanRecord?.deviceName.toString()}")
                    Log.d("Ride MAc", "${ridegriMac}")
                    Log.d("Device address", "${result.device.address}")
                    rssiRidegrid = result.rssi
                 viewModel.updateRidegridRssi(rssiRidegrid)
                }
                scanResults.add(result)
                viewModel.updateScanResults(scanResults.toList())
            }
        }
        bluetoothAdapter.bluetoothLeScanner.startScan(scanFilters, scanSettings, leScanCallback)
    }

    fun stopBleScanner() {
        bluetoothAdapter.bluetoothLeScanner.stopScan(leScanCallback)
    }
}