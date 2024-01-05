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
import com.aptener.bluconnect.common.ext.asMutableStateFlow
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

@SuppressLint("StaticFieldLeak")
class BleViewModel : ViewModel() {
    private lateinit var serivcesBle: SerivcesBle
    val _ridegridMacAddress = MutableLiveData<String>()


    private val _testScenarioResult = Channel<TestScenarioResult>()
    val _ridegridRssi = MutableStateFlow(-1000)
    val ridegridRssi: MutableStateFlow<Int>
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
            _ridegridRssi.asMutableStateFlow()?.tryEmit(rssi)
            delay(1000)
//            checkTestScenario(rssi)
        }
    }

//    private suspend fun checkTestScenario(rssi: Int) {
//        val range = 0..5
//        if (range.contains(rssi)) {
//            _testScenarioResult.send(TestScenarioResult.PASSED)
//        } else {
//            _testScenarioResult.send(TestScenarioResult.FAILED)
//        }
//    }
}

sealed class TestScenarioResult {
    object PASSED : TestScenarioResult()
    object FAILED : TestScenarioResult()
}