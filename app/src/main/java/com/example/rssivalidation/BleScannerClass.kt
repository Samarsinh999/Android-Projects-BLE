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
    val scanResults: MutableList<ScanResult> = mutableListOf()
    private var leScanCallback: ScanCallback? = null
    var rssiRidegrid: Int = -0
    var resultrssi: Int = 12

    fun startBleScanner(scanFilters: List<ScanFilter>, scanSettings: ScanSettings) {
        leScanCallback = object : ScanCallback() {
            @SuppressLint("SuspiciousIndentation")
            override fun onScanResult(callbackType: Int, result: ScanResult) {
                super.onScanResult(callbackType, result)
                if (result.device.address == viewModel._ridegridMacAddress.value) {
//                    Log.d("Ride MAc", "${ridegriMac}")
//                    Log.d("Device address", "${result.device.address}")
                    rssiRidegrid = result.rssi
                 viewModel.updateRidegridRssi(rssiRidegrid)
                }
                resultrssi = result.rssi
                val devAddress = result.device.address
//                if (devAddress == resultrssi.toString()){
                    Log.d("RSSSSI", "${resultrssi}")
                    Log.d("devADDD", "${devAddress}")
                if (devAddress == resultrssi.toString())
                    resultrssi = result.rssi
                    viewModel.updateBleRssi(resultrssi)
                    scanResults.add(result)
//                }
                viewModel.updateScanResults(scanResults)
            }
        }
        bluetoothAdapter.bluetoothLeScanner.startScan(scanFilters, scanSettings, leScanCallback)
    }

    fun stopBleScanner() {
        bluetoothAdapter.bluetoothLeScanner.stopScan(leScanCallback)
    }
}