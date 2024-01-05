package com.example.rssivalidation;

import java.lang.System;

@android.annotation.SuppressLint(value = {"StaticFieldLeak"})
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u0005J\u000e\u0010#\u001a\u00020!2\u0006\u0010$\u001a\u00020\nJ\u0014\u0010%\u001a\u00020!2\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fR\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f0\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00050\u00158F\u00a2\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\n0\t8F\u00a2\u0006\u0006\u001a\u0004\b\u0019\u0010\fR\u001d\u0010\u001a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f0\u001b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u000e\u0010\u001e\u001a\u00020\u001fX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\'"}, d2 = {"Lcom/example/rssivalidation/BleViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "_ridegridMacAddress", "Landroidx/lifecycle/MutableLiveData;", "", "get_ridegridMacAddress", "()Landroidx/lifecycle/MutableLiveData;", "_ridegridRssi", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "get_ridegridRssi", "()Lkotlinx/coroutines/flow/MutableStateFlow;", "_scanResults", "Landroidx/compose/runtime/MutableState;", "", "Landroid/bluetooth/le/ScanResult;", "_testScenarioResult", "Lkotlinx/coroutines/channels/Channel;", "Lcom/example/rssivalidation/TestScenarioResult;", "ridegridMacAddress", "Landroidx/lifecycle/LiveData;", "getRidegridMacAddress", "()Landroidx/lifecycle/LiveData;", "ridegridRssi", "getRidegridRssi", "scanResults", "Landroidx/compose/runtime/State;", "getScanResults", "()Landroidx/compose/runtime/State;", "serivcesBle", "Lcom/example/rssivalidation/SerivcesBle;", "setRidegridMacAddress", "", "macAddress", "updateRidegridRssi", "rssi", "updateScanResults", "newResults", "app_debug"})
public final class BleViewModel extends androidx.lifecycle.ViewModel {
    private com.example.rssivalidation.SerivcesBle serivcesBle;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.MutableLiveData<java.lang.String> _ridegridMacAddress = null;
    private final kotlinx.coroutines.channels.Channel<com.example.rssivalidation.TestScenarioResult> _testScenarioResult = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.Integer> _ridegridRssi = null;
    private final androidx.compose.runtime.MutableState<java.util.List<android.bluetooth.le.ScanResult>> _scanResults = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.compose.runtime.State<java.util.List<android.bluetooth.le.ScanResult>> scanResults = null;
    
    public BleViewModel() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.MutableLiveData<java.lang.String> get_ridegridMacAddress() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.MutableStateFlow<java.lang.Integer> get_ridegridRssi() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.MutableStateFlow<java.lang.Integer> getRidegridRssi() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.compose.runtime.State<java.util.List<android.bluetooth.le.ScanResult>> getScanResults() {
        return null;
    }
    
    public final void updateScanResults(@org.jetbrains.annotations.NotNull
    java.util.List<android.bluetooth.le.ScanResult> newResults) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<java.lang.String> getRidegridMacAddress() {
        return null;
    }
    
    public final void setRidegridMacAddress(@org.jetbrains.annotations.NotNull
    java.lang.String macAddress) {
    }
    
    public final void updateRidegridRssi(int rssi) {
    }
}