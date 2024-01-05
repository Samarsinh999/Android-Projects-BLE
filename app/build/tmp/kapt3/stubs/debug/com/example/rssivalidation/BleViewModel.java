package com.example.rssivalidation;

import java.lang.System;

@android.annotation.SuppressLint(value = {"StaticFieldLeak"})
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0019\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\bH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001eJ\u000e\u0010\u001f\u001a\u00020\u001c2\u0006\u0010 \u001a\u00020\u0005J\u000e\u0010!\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\bJ\u0014\u0010\"\u001a\u00020\u001c2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\f0\u000bR\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00050\u00118F\u00a2\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\b0\u00078F\u00a2\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u001d\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\u0018\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001a\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006$"}, d2 = {"Lcom/example/rssivalidation/BleViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "_ridegridMacAddress", "Landroidx/lifecycle/MutableLiveData;", "", "_ridegridRssi", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "_scanResults", "Landroidx/compose/runtime/MutableState;", "", "Landroid/bluetooth/le/ScanResult;", "_testScenarioResult", "Lkotlinx/coroutines/channels/Channel;", "Lcom/example/rssivalidation/TestScenarioResult;", "ridegridMacAddress", "Landroidx/lifecycle/LiveData;", "getRidegridMacAddress", "()Landroidx/lifecycle/LiveData;", "ridegridRssi", "getRidegridRssi", "()Lkotlinx/coroutines/flow/MutableStateFlow;", "scanResults", "Landroidx/compose/runtime/State;", "getScanResults", "()Landroidx/compose/runtime/State;", "checkTestScenario", "", "rssi", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setRidegridMacAddress", "macAddress", "updateRidegridRssi", "updateScanResults", "newResults", "app_debug"})
public final class BleViewModel extends androidx.lifecycle.ViewModel {
    private final androidx.lifecycle.MutableLiveData<java.lang.String> _ridegridMacAddress = null;
    private final kotlinx.coroutines.channels.Channel<com.example.rssivalidation.TestScenarioResult> _testScenarioResult = null;
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.Integer> _ridegridRssi = null;
    private final androidx.compose.runtime.MutableState<java.util.List<android.bluetooth.le.ScanResult>> _scanResults = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.compose.runtime.State<java.util.List<android.bluetooth.le.ScanResult>> scanResults = null;
    
    public BleViewModel() {
        super();
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
    
    private final java.lang.Object checkTestScenario(int rssi, kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
}