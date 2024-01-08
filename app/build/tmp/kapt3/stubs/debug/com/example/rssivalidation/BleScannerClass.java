package com.example.rssivalidation;

import java.lang.System;

@android.annotation.SuppressLint(value = {"MissingPermission"})
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u001c\u0010\u0018\u001a\u00020\u00192\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b2\u0006\u0010\u001d\u001a\u00020\u001eJ\u0006\u0010\u001f\u001a\u00020\u0019R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0011\u0010\t\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006 "}, d2 = {"Lcom/example/rssivalidation/BleScannerClass;", "", "viewModel", "Lcom/example/rssivalidation/BleViewModel;", "bluetoothAdapter", "Landroid/bluetooth/BluetoothAdapter;", "(Lcom/example/rssivalidation/BleViewModel;Landroid/bluetooth/BluetoothAdapter;)V", "leScanCallback", "Landroid/bluetooth/le/ScanCallback;", "ridegriMac", "", "getRidegriMac", "()Ljava/lang/String;", "rssiRidegrid", "", "getRssiRidegrid", "()I", "setRssiRidegrid", "(I)V", "scanResults", "", "Landroid/bluetooth/le/ScanResult;", "serivcesBle", "Lcom/example/rssivalidation/SerivcesBle;", "startBleScanner", "", "scanFilters", "", "Landroid/bluetooth/le/ScanFilter;", "scanSettings", "Landroid/bluetooth/le/ScanSettings;", "stopBleScanner", "app_debug"})
public final class BleScannerClass {
    private final com.example.rssivalidation.BleViewModel viewModel = null;
    private final android.bluetooth.BluetoothAdapter bluetoothAdapter = null;
    private com.example.rssivalidation.SerivcesBle serivcesBle;
    private final java.util.List<android.bluetooth.le.ScanResult> scanResults = null;
    private android.bluetooth.le.ScanCallback leScanCallback;
    private int rssiRidegrid = 0;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String ridegriMac = null;
    
    public BleScannerClass(@org.jetbrains.annotations.NotNull
    com.example.rssivalidation.BleViewModel viewModel, @org.jetbrains.annotations.NotNull
    android.bluetooth.BluetoothAdapter bluetoothAdapter) {
        super();
    }
    
    public final int getRssiRidegrid() {
        return 0;
    }
    
    public final void setRssiRidegrid(int p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getRidegriMac() {
        return null;
    }
    
    public final void startBleScanner(@org.jetbrains.annotations.NotNull
    java.util.List<android.bluetooth.le.ScanFilter> scanFilters, @org.jetbrains.annotations.NotNull
    android.bluetooth.le.ScanSettings scanSettings) {
    }
    
    public final void stopBleScanner() {
    }
}