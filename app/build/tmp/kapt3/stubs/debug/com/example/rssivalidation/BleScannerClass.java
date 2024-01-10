package com.example.rssivalidation;

import java.lang.System;

@android.annotation.SuppressLint(value = {"MissingPermission"})
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u001c\u0010\u0015\u001a\u00020\u00162\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u00182\u0006\u0010\u001a\u001a\u00020\u001bJ\u0006\u0010\u001c\u001a\u00020\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001d"}, d2 = {"Lcom/example/rssivalidation/BleScannerClass;", "", "viewModel", "Lcom/example/rssivalidation/BleViewModel;", "bluetoothAdapter", "Landroid/bluetooth/BluetoothAdapter;", "(Lcom/example/rssivalidation/BleViewModel;Landroid/bluetooth/BluetoothAdapter;)V", "leScanCallback", "Landroid/bluetooth/le/ScanCallback;", "resultrssi", "", "getResultrssi", "()I", "setResultrssi", "(I)V", "rssiRidegrid", "getRssiRidegrid", "setRssiRidegrid", "scanResults", "", "Landroid/bluetooth/le/ScanResult;", "startBleScanner", "", "scanFilters", "", "Landroid/bluetooth/le/ScanFilter;", "scanSettings", "Landroid/bluetooth/le/ScanSettings;", "stopBleScanner", "app_debug"})
public final class BleScannerClass {
    private final com.example.rssivalidation.BleViewModel viewModel = null;
    private final android.bluetooth.BluetoothAdapter bluetoothAdapter = null;
    private final java.util.List<android.bluetooth.le.ScanResult> scanResults = null;
    private android.bluetooth.le.ScanCallback leScanCallback;
    private int rssiRidegrid = 0;
    private int resultrssi = 12;
    
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
    
    public final int getResultrssi() {
        return 0;
    }
    
    public final void setResultrssi(int p0) {
    }
    
    public final void startBleScanner(@org.jetbrains.annotations.NotNull
    java.util.List<android.bluetooth.le.ScanFilter> scanFilters, @org.jetbrains.annotations.NotNull
    android.bluetooth.le.ScanSettings scanSettings) {
    }
    
    public final void stopBleScanner() {
    }
}