package com.example.rssivalidation

import android.annotation.SuppressLint
import android.bluetooth.le.ScanResult
import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

@SuppressLint("StaticFieldLeak")
class BleViewModel : ViewModel() {
    var _ridegridMacAddress = MutableLiveData<String>()
    var _ridegridRssi = MutableStateFlow(-0)
    var _Rssi = MutableStateFlow(-121)
    val ridegridRssi: StateFlow<Int>
        get() = _ridegridRssi

    val resultdRssi: StateFlow<Int>
        get() = _Rssi

    private val _scanResults = mutableStateOf(emptyList<ScanResult>())
    val scanResults: MutableState<List<ScanResult>> get() = _scanResults

    fun updateScanResults(newResults: List<ScanResult>) {
        val currentResult = _scanResults.value
        val uniqueResultDevices = (currentResult + newResults).distinctBy { it.device.address }
        _scanResults.value = uniqueResultDevices
    }

    fun setRidegridMacAddress(macAddress: String) {
        _ridegridMacAddress.value = macAddress
        Log.d("Getting Mac from Main","${macAddress}")
    }

    fun updateRidegridRssi(rssi: Int) {
        viewModelScope.launch {
            _ridegridRssi.tryEmit(rssi)
//            Log.d("Viewmodel RSSI", "${rssi}")
            delay(1000)
//            checkTestScenario(rssi)
        }
    }

    fun updateBleRssi(pwd: Int) {
        viewModelScope.launch {
            _Rssi.tryEmit(pwd)
            Log.d("Viewmodel RSSI", "${pwd}")
            delay(1000)
        }
    }

    @OptIn(DelicateCoroutinesApi::class)
    fun clearAndSetData() {
          GlobalScope.launch {
              scanResults.value = emptyList()
          }
    }
}

sealed class TestScenarioResult {
    object PASSED : TestScenarioResult()
    object FAILED : TestScenarioResult()
}