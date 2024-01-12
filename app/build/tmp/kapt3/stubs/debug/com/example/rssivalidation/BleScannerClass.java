package com.example.rssivalidation;

import java.lang.System;

@android.annotation.SuppressLint(value = {"MissingPermission"})
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0016H\u0002J\u001c\u0010\u001c\u001a\u00020\u001a2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001e2\u0006\u0010 \u001a\u00020!J\u0006\u0010\"\u001a\u00020\u001aR\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\n\"\u0004\b\u0013\u0010\fR\u0017\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006#"}, d2 = {"Lcom/example/rssivalidation/BleScannerClass;", "", "viewModel", "Lcom/example/rssivalidation/BleViewModel;", "bluetoothAdapter", "Landroid/bluetooth/BluetoothAdapter;", "(Lcom/example/rssivalidation/BleViewModel;Landroid/bluetooth/BluetoothAdapter;)V", "_RSSSI", "", "get_RSSSI", "()I", "set_RSSSI", "(I)V", "isScanning", "", "leScanCallback", "Landroid/bluetooth/le/ScanCallback;", "rssiRidegrid", "getRssiRidegrid", "setRssiRidegrid", "scanResults", "", "Landroid/bluetooth/le/ScanResult;", "getScanResults", "()Ljava/util/List;", "handleScanResult", "", "result", "startBleScanner", "scanFilters", "", "Landroid/bluetooth/le/ScanFilter;", "scanSettings", "Landroid/bluetooth/le/ScanSettings;", "stopBleScanner", "app_debug"})
public final class BleScannerClass {
    private final com.example.rssivalidation.BleViewModel viewModel = null;
    private final android.bluetooth.BluetoothAdapter bluetoothAdapter = null;
    @org.jetbrains.annotations.NotNull
    private final java.util.List<android.bluetooth.le.ScanResult> scanResults = null;
    private android.bluetooth.le.ScanCallback leScanCallback;
    private boolean isScanning = false;
    private int rssiRidegrid = 0;
    private int _RSSSI = 0;
    
    public BleScannerClass(@org.jetbrains.annotations.NotNull
    com.example.rssivalidation.BleViewModel viewModel, @org.jetbrains.annotations.NotNull
    android.bluetooth.BluetoothAdapter bluetoothAdapter) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<android.bluetooth.le.ScanResult> getScanResults() {
        return null;
    }
    
    public final int getRssiRidegrid() {
        return 0;
    }
    
    public final void setRssiRidegrid(int p0) {
    }
    
    public final int get_RSSSI() {
        return 0;
    }
    
    public final void set_RSSSI(int p0) {
    }
    
    public final void startBleScanner(@org.jetbrains.annotations.NotNull
    java.util.List<android.bluetooth.le.ScanFilter> scanFilters, @org.jetbrains.annotations.NotNull
    android.bluetooth.le.ScanSettings scanSettings) {
    }
    
    public final void stopBleScanner() {
    }
    
    private final void handleScanResult(android.bluetooth.le.ScanResult result) {
    }
}