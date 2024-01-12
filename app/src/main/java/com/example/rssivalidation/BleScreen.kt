package com.example.rssivalidation

import android.annotation.SuppressLint
import android.bluetooth.le.ScanResult
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.pullrefresh.PullRefreshIndicator
import androidx.compose.material.pullrefresh.pullRefresh
import androidx.compose.material.pullrefresh.rememberPullRefreshState
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.Observer
import kotlinx.coroutines.launch
import java.util.Timer
import kotlin.concurrent.schedule

@OptIn(ExperimentalFoundationApi::class, ExperimentalMaterialApi::class)
@Composable
fun BleScreen(viewModel: BleViewModel, mainActivity: MainActivity) {
    val refreshScope = rememberCoroutineScope()
    var refreshing by remember { mutableStateOf(false) }
    val isScanning by remember { mutableStateOf(true) }

    fun refresh() = refreshScope.launch {
        refreshing = true
       Timer().schedule(1000){
           mainActivity.startBleScanner()
           viewModel.clearAndSetData()
           refreshing = false
       }
    }

    val state = rememberPullRefreshState(refreshing, ::refresh)
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // paired Device
        LazyColumn(
            modifier = Modifier
                .wrapContentSize()
        ) {
            stickyHeader {
                Text(
                    text = "Paired Devices",
                    fontWeight = FontWeight.Bold,
                    fontSize = 25.sp,
                    color = Color.Black,
                    modifier = Modifier
                        .background(Color.White)
                        .padding(16.dp)
                )
            }
            item{
                    DeviceImpl(viewModel = viewModel)
                }
        }

        val scanResults by viewModel.scanResults
        Box(Modifier.pullRefresh(state)) {
            LazyColumn(
                modifier = Modifier
                    .height(450.dp)
                    .width(500.dp)
            ) {
                stickyHeader {
                    Text(
                        text = "Scanned Devices",
                        fontWeight = FontWeight.Bold,
                        fontSize = 25.sp,
                        color = Color.Black,
                        modifier = Modifier
                            .background(Color.White)
                            .fillMaxWidth()
                            .padding(16.dp)
                    )
                }
                items(scanResults) { result ->
                    ScanResultItem(result, viewModel)
                }
            }
            PullRefreshIndicator(refreshing, state, Modifier.align(Alignment.TopCenter))
        }
        // Buttons fixed at the bottom
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp),
            verticalAlignment = Alignment.Bottom,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Button(
                modifier = Modifier
                    .padding(16.dp),
                onClick = {
                    mainActivity.startBleScanner()
                },
                enabled = true
            ) {
                Text(text = "Start Scan")
            }

            Button(
                modifier = Modifier
                    .padding(16.dp),
                onClick = {
                    mainActivity.stopBleScanner()
                    viewModel.clearAndSetData()
                },
                enabled = true
            ) {
                Text(text = "Stop Scan")
            }
        }
    }
}


@Composable
fun DeviceImpl(viewModel: BleViewModel) {
    var macAddress by remember { mutableStateOf("") }
    val ridegridRssi by viewModel.ridegridRssi.collectAsState()
    val observer = Observer<String> { newMacAddress ->
        macAddress = newMacAddress
//        Log.d("node Mac", "${newMacAddress}")
    }
    viewModel._ridegridMacAddress.observeForever(observer)

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .background(Color.White)
    ) {
        Row {
            // First Column
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = "Name:",
                    fontWeight = FontWeight.Bold
                )
                Text(text = "NAME")
                Text(
                    text = "MAC Address:",
                    fontWeight = FontWeight.Bold
                )
                Text(text = macAddress)
            }

            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 16.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Absolute.Right
                ) {
                    Text(
                        text = "RSSI:",
                        fontWeight = FontWeight.Bold,
                        color = Color.Gray
                    )
                    Text(
                        text = ridegridRssi.toString(),
                        color = Color.Gray
                    )
                }
            }
        }
    }
}
//
//@SuppressLint("MissingPermission", "UnrememberedMutableState")
//@Composable
//fun ScanResultItem(result: ScanResult,viewModel: BleViewModel) {
//
//    Column(
//        modifier = Modifier
//            .fillMaxWidth()
//            .padding(16.dp)
//            .background(Color.White)
//    ) {
//        Row {
//            // First Column
//            Column(
//                modifier = Modifier.weight(1f)
//            ) {
//                Text(
//                    text = "Name:",
//                    fontWeight = FontWeight.Bold
//                )
//                if (result.device.name != null){
//                    Text(text = result.device.name)
//                }
//                Text(
//                    text = "MAC Address:",
//                    fontWeight = FontWeight.Bold
//                )
//                Text(text = result.device.address)
//            }
//            Column(
//                modifier = Modifier
//                    .weight(1f)
//                    .padding(start = 16.dp)
//            ) {
//                Row(
//                    modifier = Modifier.fillMaxWidth(),
//                    horizontalArrangement = Arrangement.Absolute.Right
//                ) {
//                    Text(
//                        text = "RSSI:",
//                        fontWeight = FontWeight.Bold,
//                        color = Color.Gray
//                    )
//                    Text(
//                        text = result.rssi.toString(),
//                        color = Color.Gray
//                    )
//                }
//            }
//        }
//    }
//}

@SuppressLint("MissingPermission", "UnrememberedMutableState")
@Composable
fun ScanResultItem(result: ScanResult, viewModel: BleViewModel) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .background(Color.White)
    ) {
        Row {
            // First Column
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = "Name:",
                    fontWeight = FontWeight.Bold
                )
                if (result.device.name != null) {
                    Text(text = result.device.name)
                }
                Text(
                    text = "MAC Address:",
                    fontWeight = FontWeight.Bold
                )
                Text(text = result.device.address)
            }
            // Second Column
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 16.dp)
            ) {
                // Displays Dyanamic RSSI here
                val deviceAddress = result.device.address
                val rssi by viewModel.observeRssi(deviceAddress).collectAsState()
                Text(
                    text = "RSSI: ${rssi ?: "N/A"}",
                    fontWeight = FontWeight.Bold,
                    color = Color.Gray
                )

                // Initial RSSI when Scanned
//                Row(
//                    modifier = Modifier.fillMaxWidth(),
//                    horizontalArrangement = Arrangement.Absolute.Right
//                ) {
//                    Text(
//                        text = "Original RSSI:",
//                        fontWeight = FontWeight.Bold,
//                        color = Color.Gray
//                    )
//                    Text(
//                        text = result.rssi.toString(),
//                        color = Color.Gray
//                    )
//                }
            }
        }
    }
}


//    val rRssi by viewModel.resultdRssi.collectAsState()