package com.example.rssivalidation;

import java.lang.System;

@android.annotation.SuppressLint(value = {"StaticFieldLeak"})
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010#\u001a\u00020$J\u0014\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00050\u001b2\u0006\u0010&\u001a\u00020\fJ\u000e\u0010\'\u001a\u00020$2\u0006\u0010&\u001a\u00020\fJ\u0016\u0010(\u001a\u00020$2\u0006\u0010&\u001a\u00020\f2\u0006\u0010)\u001a\u00020\u0005J\u000e\u0010*\u001a\u00020$2\u0006\u0010)\u001a\u00020\u0005J\u0014\u0010+\u001a\u00020$2\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018R \u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R \u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0007\"\u0004\b\u0013\u0010\tR \u0010\u0014\u001a\u0014\u0012\u0004\u0012\u00020\f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0015X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u00180\u0017X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00050\u001b8F\u00a2\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u0017\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00050\u001b8F\u00a2\u0006\u0006\u001a\u0004\b\u001f\u0010\u001dR\u001d\u0010 \u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u00180\u00178F\u00a2\u0006\u0006\u001a\u0004\b!\u0010\"\u00a8\u0006-"}, d2 = {"Lcom/example/rssivalidation/BleViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "_Rssi", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "get_Rssi", "()Lkotlinx/coroutines/flow/MutableStateFlow;", "set_Rssi", "(Lkotlinx/coroutines/flow/MutableStateFlow;)V", "_ridegridMacAddress", "Landroidx/lifecycle/MutableLiveData;", "", "get_ridegridMacAddress", "()Landroidx/lifecycle/MutableLiveData;", "set_ridegridMacAddress", "(Landroidx/lifecycle/MutableLiveData;)V", "_ridegridRssi", "get_ridegridRssi", "set_ridegridRssi", "_rssiMap", "", "_scanResults", "Landroidx/compose/runtime/MutableState;", "", "Landroid/bluetooth/le/ScanResult;", "resultdRssi", "Lkotlinx/coroutines/flow/StateFlow;", "getResultdRssi", "()Lkotlinx/coroutines/flow/StateFlow;", "ridegridRssi", "getRidegridRssi", "scanResults", "getScanResults", "()Landroidx/compose/runtime/MutableState;", "clearAndSetData", "", "observeRssi", "macAddress", "setRidegridMacAddress", "updateBleRssi", "rssi", "updateRidegridRssi", "updateScanResults", "newResults", "app_debug"})
public final class BleViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull
    private androidx.lifecycle.MutableLiveData<java.lang.String> _ridegridMacAddress;
    @org.jetbrains.annotations.NotNull
    private kotlinx.coroutines.flow.MutableStateFlow<java.lang.Integer> _ridegridRssi;
    @org.jetbrains.annotations.NotNull
    private kotlinx.coroutines.flow.MutableStateFlow<java.lang.Integer> _Rssi;
    private final java.util.Map<java.lang.String, kotlinx.coroutines.flow.MutableStateFlow<java.lang.Integer>> _rssiMap = null;
    private final androidx.compose.runtime.MutableState<java.util.List<android.bluetooth.le.ScanResult>> _scanResults = null;
    
    public BleViewModel() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.MutableLiveData<java.lang.String> get_ridegridMacAddress() {
        return null;
    }
    
    public final void set_ridegridMacAddress(@org.jetbrains.annotations.NotNull
    androidx.lifecycle.MutableLiveData<java.lang.String> p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.MutableStateFlow<java.lang.Integer> get_ridegridRssi() {
        return null;
    }
    
    public final void set_ridegridRssi(@org.jetbrains.annotations.NotNull
    kotlinx.coroutines.flow.MutableStateFlow<java.lang.Integer> p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.MutableStateFlow<java.lang.Integer> get_Rssi() {
        return null;
    }
    
    public final void set_Rssi(@org.jetbrains.annotations.NotNull
    kotlinx.coroutines.flow.MutableStateFlow<java.lang.Integer> p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<java.lang.Integer> getRidegridRssi() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<java.lang.Integer> getResultdRssi() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.compose.runtime.MutableState<java.util.List<android.bluetooth.le.ScanResult>> getScanResults() {
        return null;
    }
    
    public final void updateScanResults(@org.jetbrains.annotations.NotNull
    java.util.List<android.bluetooth.le.ScanResult> newResults) {
    }
    
    public final void setRidegridMacAddress(@org.jetbrains.annotations.NotNull
    java.lang.String macAddress) {
    }
    
    public final void updateRidegridRssi(int rssi) {
    }
    
    @kotlin.OptIn(markerClass = {kotlinx.coroutines.DelicateCoroutinesApi.class})
    public final void clearAndSetData() {
    }
    
    public final void updateBleRssi(@org.jetbrains.annotations.NotNull
    java.lang.String macAddress, int rssi) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<java.lang.Integer> observeRssi(@org.jetbrains.annotations.NotNull
    java.lang.String macAddress) {
        return null;
    }
}