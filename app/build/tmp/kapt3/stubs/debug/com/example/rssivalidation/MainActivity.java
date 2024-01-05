package com.example.rssivalidation;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\u000e\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eJ\u0012\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0015J\u001c\u0010#\u001a\u00020 2\b\u0010$\u001a\u0004\u0018\u00010%2\b\u0010&\u001a\u0004\u0018\u00010\'H\u0017J\u0012\u0010(\u001a\u00020 2\b\u0010$\u001a\u0004\u0018\u00010%H\u0016J\b\u0010)\u001a\u00020 H\u0014J\u0010\u0010*\u001a\u00020\u001c2\b\u0010+\u001a\u0004\u0018\u00010\u001cJ\u0006\u0010,\u001a\u00020 J\u0006\u0010-\u001a\u00020 R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0010\u001a\n \u0012*\u0004\u0018\u00010\u00110\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001b\u0010\u0015\u001a\u00020\u00168BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0017\u0010\u0018\u00a8\u0006."}, d2 = {"Lcom/example/rssivalidation/MainActivity;", "Landroidx/activity/ComponentActivity;", "Landroid/content/ServiceConnection;", "()V", "bleScanner", "Lcom/example/rssivalidation/BleScannerClass;", "bluService", "Lkotlinx/coroutines/flow/StateFlow;", "Lcom/example/rssivalidation/SerivcesBle;", "receive", "Landroid/content/BroadcastReceiver;", "scanFilter", "", "Landroid/bluetooth/le/ScanFilter;", "getScanFilter", "()Ljava/util/List;", "scanSettings", "Landroid/bluetooth/le/ScanSettings;", "kotlin.jvm.PlatformType", "getScanSettings", "()Landroid/bluetooth/le/ScanSettings;", "viewModel", "Lcom/example/rssivalidation/BleViewModel;", "getViewModel", "()Lcom/example/rssivalidation/BleViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "macByteStringToString", "", "macAddress", "Lcom/google/protobuf/ByteString;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onServiceConnected", "name", "Landroid/content/ComponentName;", "service", "Landroid/os/IBinder;", "onServiceDisconnected", "onStart", "reverseMACAddress", "str", "startBleScanner", "stopBleScanner", "app_debug"})
public final class MainActivity extends androidx.activity.ComponentActivity implements android.content.ServiceConnection {
    private final kotlinx.coroutines.flow.StateFlow<com.example.rssivalidation.SerivcesBle> bluService = null;
    private final kotlin.Lazy viewModel$delegate = null;
    private com.example.rssivalidation.BleScannerClass bleScanner;
    @org.jetbrains.annotations.NotNull
    private final java.util.List<android.bluetooth.le.ScanFilter> scanFilter = null;
    private final android.bluetooth.le.ScanSettings scanSettings = null;
    private final android.content.BroadcastReceiver receive = null;
    
    public MainActivity() {
        super();
    }
    
    private final com.example.rssivalidation.BleViewModel getViewModel() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<android.bluetooth.le.ScanFilter> getScanFilter() {
        return null;
    }
    
    public final android.bluetooth.le.ScanSettings getScanSettings() {
        return null;
    }
    
    @android.annotation.SuppressLint(value = {"CoroutineCreationDuringComposition", "StateFlowValueCalledInComposition"})
    @java.lang.Override
    protected void onCreate(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override
    protected void onStart() {
    }
    
    @android.annotation.SuppressLint(value = {"MissingPermission"})
    @java.lang.Override
    public void onServiceConnected(@org.jetbrains.annotations.Nullable
    android.content.ComponentName name, @org.jetbrains.annotations.Nullable
    android.os.IBinder service) {
    }
    
    @java.lang.Override
    public void onServiceDisconnected(@org.jetbrains.annotations.Nullable
    android.content.ComponentName name) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String reverseMACAddress(@org.jetbrains.annotations.Nullable
    java.lang.String str) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String macByteStringToString(@org.jetbrains.annotations.NotNull
    com.google.protobuf.ByteString macAddress) {
        return null;
    }
    
    public final void startBleScanner() {
    }
    
    public final void stopBleScanner() {
    }
}