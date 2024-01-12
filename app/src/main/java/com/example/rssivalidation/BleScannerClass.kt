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
            leScanCallback = object : ScanCallback() {
                @SuppressLint("SuspiciousIndentation")
                override fun onScanResult(callbackType: Int, result: ScanResult) {
                    super.onScanResult(callbackType, result)
                    scanResults.add(result)
                    viewModel.updateScanResults(scanResults)
                    _RSSSI = result.rssi
                    val devAddress = result.device.address
                    Log.d("RSSSSI", "${_RSSSI}")
                    Log.d("devADDD", "${devAddress}")
                    viewModel.updateBleRssi(devAddress, _RSSSI)
                    handleScanResult(result)
                }
            }
        bluetoothAdapter.bluetoothLeScanner.startScan(scanFilters, scanSettings, leScanCallback)
    }

    fun stopBleScanner() {
        bluetoothAdapter.bluetoothLeScanner.stopScan(leScanCallback)
    }

    private fun handleScanResult(result: ScanResult) {
        if (result.device.address == viewModel._ridegridMacAddress.value) {
            rssiRidegrid = result.rssi
            viewModel.updateRidegridRssi(rssiRidegrid)
        }
    }
}