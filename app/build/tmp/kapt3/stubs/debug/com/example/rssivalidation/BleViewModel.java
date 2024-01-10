package com.example.rssivalidation;

import java.lang.System;

@android.annotation.SuppressLint(value = {"StaticFieldLeak"})
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0005J\u000e\u0010 \u001a\u00020\u001e2\u0006\u0010!\u001a\u00020\fJ\u0014\u0010\"\u001a\u00020\u001e2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013R \u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u00130\u0012X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\f0\u00168F\u00a2\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u001d\u0010\u0019\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u00130\u001a\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001c\u00a8\u0006$"}, d2 = {"Lcom/example/rssivalidation/BleViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "_ridegridMacAddress", "Landroidx/lifecycle/MutableLiveData;", "", "get_ridegridMacAddress", "()Landroidx/lifecycle/MutableLiveData;", "set_ridegridMacAddress", "(Landroidx/lifecycle/MutableLiveData;)V", "_ridegridRssi", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "get_ridegridRssi", "()Lkotlinx/coroutines/flow/MutableStateFlow;", "set_ridegridRssi", "(Lkotlinx/coroutines/flow/MutableStateFlow;)V", "_scanResults", "Landroidx/compose/runtime/MutableState;", "", "Landroid/bluetooth/le/ScanResult;", "ridegridRssi", "Lkotlinx/coroutines/flow/StateFlow;", "getRidegridRssi", "()Lkotlinx/coroutines/flow/StateFlow;", "scanResults", "Landroidx/compose/runtime/State;", "getScanResults", "()Landroidx/compose/runtime/State;", "setRidegridMacAddress", "", "macAddress", "updateRidegridRssi", "rssi", "updateScanResults", "newResults", "app_debug"})
public final class BleViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull
    private androidx.lifecycle.MutableLiveData<java.lang.String> _ridegridMacAddress;
    @org.jetbrains.annotations.NotNull
    private kotlinx.coroutines.flow.MutableStateFlow<java.lang.Integer> _ridegridRssi;
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
    public final kotlinx.coroutines.flow.StateFlow<java.lang.Integer> getRidegridRssi() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.compose.runtime.State<java.util.List<android.bluetooth.le.ScanResult>> getScanResults() {
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
}