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
    private var isScanning: Boolean = false
    var rssiRidegrid: Int = -0
    var _RSSSI: Int = -0

    fun startBleScanner(scanFilters: List<ScanFilter>, scanSettings: ScanSettings) {
        if (!isScanning) {
            leScanCallback = object : ScanCallback() {
                @SuppressLint("SuspiciousIndentation")
                override fun onScanResult(callbackType: Int, result: ScanResult) {
                    super.onScanResult(callbackType, result)
                    scanResults.add(result)
                    viewModel.updateScanResults(scanResults)
                    if (result.device.address == result.rssi.toString()){
                        _RSSSI = result.rssi
                        viewModel.updateBleRssi(_RSSSI)
                        Log.d("ClassnRSSI", "${result.rssi}")
                    }
                    handleScanResult(result)
                }
            }
            try {
                bluetoothAdapter.bluetoothLeScanner.startScan(scanFilters, scanSettings, leScanCallback)
                isScanning = true
                Log.d("BleScannerClass", "Scan started")
            }
           catch (e: Exception) {
                Log.e("BleScannerClass", "Error starting scan: ${e.message}")
           }
        }
        else {
            Log.d("BleScannerClass", "Scan is already in progress")
        }
    }

    fun stopBleScanner() {
//        if (isScanning) {
//            bluetoothAdapter.bluetoothLeScanner.stopScan(leScanCallback)
//            leScanCallback = null
//            isScanning = false
//        }
        if (isScanning) {
            try {
                bluetoothAdapter.bluetoothLeScanner.stopScan(leScanCallback)
                leScanCallback = null
                isScanning = false
                Log.d("BleScannerClass", "Scan stopped")
            } catch (e: Exception) {
                Log.e("BleScannerClass", "Error stopping scan: ${e.message}")
            }
        } else {
            Log.d("BleScannerClass", "No scan in progress to stop")
        }
    }

    private fun handleScanResult(result: ScanResult) {
        if (result.device.address == viewModel._ridegridMacAddress.value) {
            rssiRidegrid = result.rssi
            viewModel.updateRidegridRssi(rssiRidegrid)
        }
    }
}