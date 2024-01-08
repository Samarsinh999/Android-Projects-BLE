package com.example.rssivalidation

import android.annotation.SuppressLint
import android.bluetooth.le.ScanResult
import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

@SuppressLint("StaticFieldLeak")
class BleViewModel : ViewModel() {
    var _ridegridMacAddress = MutableLiveData<String>()
    var _ridegridRssi = MutableStateFlow(-11)
    val ridegridRssi: StateFlow<Int>
        get() = _ridegridRssi

    private val _scanResults = mutableStateOf(emptyList<ScanResult>())
    val scanResults: State<List<ScanResult>> = _scanResults

    fun updateScanResults(newResults: List<ScanResult>) {
        val currentResult = _scanResults.value
        val uniqueResultDevices = (currentResult + newResults).distinctBy { it.device.address }
        _scanResults.value = uniqueResultDevices
    }

    val ridegridMacAddress: LiveData<String>
            get() = _ridegridMacAddress

    fun setRidegridMacAddress(macAddress: String) {
        _ridegridMacAddress.value = macAddress
        Log.d("Getting Mac from Main","${macAddress}")
    }

    fun updateRidegridRssi(rssi: Int) {
        viewModelScope.launch {
            _ridegridRssi.tryEmit(rssi)
            Log.d("Viewmodel RSSI", "${rssi}")
            delay(1000)
//            checkTestScenario(rssi)
        }
    }
}

sealed class TestScenarioResult {
    object PASSED : TestScenarioResult()
    object FAILED : TestScenarioResult()
}