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
    var rssiRidegrid: Int = -1000
    val ridegridMacAddress = viewModel.ridegridMacAddress

    fun startBleScanner(scanFilters: List<ScanFilter>, scanSettings: ScanSettings) {
        leScanCallback = object : ScanCallback() {
            override fun onScanResult(callbackType: Int, result: ScanResult) {
                super.onScanResult(callbackType, result)
//                scanResults.add(result)
                if (ridegridMacAddress != null){
                    handleScanResult(result)
                }
                Log.d("MACaddress: ", "${result.device.address}")
                Log.d("RSSI", "${result.rssi}")

                viewModel.updateScanResults(scanResults.toList())
            }
        }
        bluetoothAdapter.bluetoothLeScanner.startScan(scanFilters, scanSettings, leScanCallback)
    }

    fun stopBleScanner() {
        bluetoothAdapter.bluetoothLeScanner.stopScan(leScanCallback)
    }

    @SuppressLint("SuspiciousIndentation")
    private fun handleScanResult(result: ScanResult) {
//        if (ridegridMacAddress != null) {
                rssiRidegrid = result.rssi
                Log.d("Scanner_RideGrid RSSI", "${rssiRidegrid}")
                viewModel.updateRidegridRssi(rssiRidegrid)
                Log.d("Updateed_RSSI", "${viewModel.updateRidegridRssi(rssiRidegrid)}")
//            }
        }
    }
