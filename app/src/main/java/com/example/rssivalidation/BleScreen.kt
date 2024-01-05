package com.example.rssivalidation

import android.annotation.SuppressLint
import android.bluetooth.le.ScanResult
import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.Observer

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun BleScreen(viewModel: BleViewModel,mainActivity: MainActivity) {
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
        LazyColumn(
            modifier = Modifier
                .weight(1f)
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
                ScanResultItem(result)
            }
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
                }
            ) {
                Text(text = "Start Scan")
            }

            Button(
                modifier = Modifier
                    .padding(16.dp),
                onClick = {
                    mainActivity.stopBleScanner()
                },
            ) {
                Text(text = "Stop Scan")
            }
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter", "StateFlowValueCalledInComposition",
    "CoroutineCreationDuringComposition"
)
@Composable
fun DeviceImpl(viewModel: BleViewModel) {
    var macAddress by remember { mutableStateOf("") }
//    var rssi by remember { mutableStateOf("") }
    val ridegridRssi by viewModel.ridegridRssi.collectAsState()

//    val rssi by rememberUpdatedState(newValue = viewModel.ridegridRssi.collectAsState().value)
//    val rssiValue by viewModel.ridegridRssi.collectAsState()


//    LaunchedEffect(Unit) {
//        while (true) {
//            val latestRssi = viewModel.ridegridRssi.value
//            if (macAddress == viewModel.ridegridMacAddress.value) {
//                ridegridRssi = latestRssi.toString()
//            }
//            delay(400)
//        }
//    }

    val observer = Observer<String> { newMacAddress ->
        macAddress = newMacAddress
        Log.d("node Mac", "${newMacAddress}")
    }

    viewModel.ridegridMacAddress.observeForever(observer)

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

@SuppressLint("MissingPermission")
@Composable
fun ScanResultItem(result: ScanResult) {
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
                if (result.device.name != null){
                    Text(text = result.device.name)
                }
                Text(
                    text = "MAC Address:",
                    fontWeight = FontWeight.Bold
                )
                Text(text = result.device.address)
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
                        text = result.rssi.toString(),
                        color = Color.Gray
                    )
                }
            }
        }
    }
}