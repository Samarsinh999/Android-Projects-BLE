package com.example.rssivalidation;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u00c0\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001:\u0001_B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010@\u001a\u00020A2\b\u0010B\u001a\u0004\u0018\u00010!H\u0002J\u000e\u0010C\u001a\u00020\u00042\u0006\u0010D\u001a\u00020EJ\u0010\u0010F\u001a\u00020G2\u0006\u0010H\u001a\u00020IH\u0016J\u0016\u0010J\u001a\u00020A2\f\u0010K\u001a\b\u0012\u0004\u0012\u00020M0LH\u0016J\u0010\u0010N\u001a\u00020A2\u0006\u0010O\u001a\u00020\u0018H\u0017J\b\u0010P\u001a\u00020AH\u0017J\u0010\u0010Q\u001a\u00020A2\u0006\u0010R\u001a\u00020\u001bH\u0003J\"\u0010S\u001a\u0002092\b\u0010H\u001a\u0004\u0018\u00010I2\u0006\u0010T\u001a\u0002092\u0006\u0010U\u001a\u000209H\u0016J\u0010\u0010V\u001a\u00020\u00042\b\u0010W\u001a\u0004\u0018\u00010\u0004J\u0010\u0010X\u001a\u00020A2\u0006\u00103\u001a\u000204H\u0002J\u001e\u0010Y\u001a\u00020A2\f\u0010Z\u001a\b\u0012\u0004\u0012\u00020[0/2\u0006\u0010\\\u001a\u00020]H\u0007J\b\u0010^\u001a\u00020AH\u0007R\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R \u0010\u0007\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0012\u0010\u000f\u001a\u00060\u0010R\u00020\u0000X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0011\u001a\u00020\u00128BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u000eR\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u0019\u0010 \u001a\n\u0012\u0006\u0012\u0004\u0018\u00010!0\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u000eR\u001a\u0010#\u001a\u00020$X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b\'\u0010(R\u000e\u0010)\u001a\u00020*X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020,X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010-\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002000/0.\u00a2\u0006\b\n\u0000\u001a\u0004\b1\u00102R\u0017\u00103\u001a\b\u0012\u0004\u0012\u0002040\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b5\u0010\u000eR\u0017\u00106\u001a\b\u0012\u0004\u0012\u00020\u00040\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b7\u0010\u000eR\u001a\u00108\u001a\u000209X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R\u000e\u0010>\u001a\u00020?X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006`"}, d2 = {"Lcom/example/rssivalidation/SerivcesBle;", "Lcom/aptener/bluconnect/BluConnectService;", "()V", "RIDEGRID_MAC_ADDRESS", "", "getRIDEGRID_MAC_ADDRESS", "()Ljava/lang/String;", "_deviceInfoData", "Landroidx/lifecycle/MutableLiveData;", "", "activeDevice", "Lkotlinx/coroutines/flow/StateFlow;", "Lcom/aptener/bluconnect/device/BluArmorDevice;", "getActiveDevice", "()Lkotlinx/coroutines/flow/StateFlow;", "binder", "Lcom/example/rssivalidation/SerivcesBle$BluServiceBinder;", "bluetoothAdapter", "Landroid/bluetooth/BluetoothAdapter;", "getBluetoothAdapter", "()Landroid/bluetooth/BluetoothAdapter;", "bluetoothAdapter$delegate", "Lkotlin/Lazy;", "connectionState", "Lcom/aptener/bluconnect/client/ConnectionState;", "getConnectionState", "device", "Lcom/aptener/bluconnect/device/C30;", "getDevice", "()Lcom/aptener/bluconnect/device/C30;", "setDevice", "(Lcom/aptener/bluconnect/device/C30;)V", "deviceInfo", "Lcom/aptener/bluconnect/device/sxcontrol/DeviceInfo$DeviceDetails;", "getDeviceInfo", "leScanCallback", "Landroid/bluetooth/le/ScanCallback;", "getLeScanCallback", "()Landroid/bluetooth/le/ScanCallback;", "setLeScanCallback", "(Landroid/bluetooth/le/ScanCallback;)V", "notificationDeviceState", "Lcom/example/rssivalidation/NotifyDeviceState;", "receive", "Landroid/content/BroadcastReceiver;", "rideGridRiders", "Landroidx/lifecycle/LiveData;", "", "Lcom/example/rssivalidation/RideGridUserDetails;", "getRideGridRiders", "()Landroidx/lifecycle/LiveData;", "rideGridState", "Lcom/aptener/bluconnect/device/sxcontrol/RideGrid$RideGridState;", "getRideGridState", "ridegridMacAddress", "getRidegridMacAddress", "rssiRidegrid", "", "getRssiRidegrid", "()I", "setRssiRidegrid", "(I)V", "viewModel", "Lcom/example/rssivalidation/BleViewModel;", "deviceInfoObserver", "", "deviceDetails", "macByteStringToString", "macAddress", "Lcom/google/protobuf/ByteString;", "onBind", "Landroid/os/IBinder;", "intent", "Landroid/content/Intent;", "onBluArmorDeviceDiscovered", "result", "", "Lcom/aptener/bluconnect/device/AdvertisingBluArmorDevice;", "onConnectionStateChange", "state", "onCreate", "onDeviceReady", "c30", "onStartCommand", "flags", "startId", "reverseMACAddress", "str", "rideGridObserver", "startBleScanner", "scanFilters", "Landroid/bluetooth/le/ScanFilter;", "scanSettings", "Landroid/bluetooth/le/ScanSettings;", "stopBleScanner", "BluServiceBinder", "app_debug"})
public final class SerivcesBle extends com.aptener.bluconnect.BluConnectService {
    private final com.example.rssivalidation.NotifyDeviceState notificationDeviceState = null;
    @org.jetbrains.annotations.Nullable
    private com.aptener.bluconnect.device.C30 device;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<com.aptener.bluconnect.device.sxcontrol.DeviceInfo.DeviceDetails> deviceInfo = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<com.aptener.bluconnect.device.BluArmorDevice> activeDevice = null;
    private final androidx.lifecycle.MutableLiveData<java.util.Map<java.lang.String, java.lang.String>> _deviceInfoData = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<com.aptener.bluconnect.client.ConnectionState> connectionState = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<java.lang.String> ridegridMacAddress = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.LiveData<java.util.List<com.example.rssivalidation.RideGridUserDetails>> rideGridRiders = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<com.aptener.bluconnect.device.sxcontrol.RideGrid.RideGridState> rideGridState = null;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String RIDEGRID_MAC_ADDRESS = "EF:AE:89:F9:B8:83";
    private int rssiRidegrid = -1000;
    public android.bluetooth.le.ScanCallback leScanCallback;
    private com.example.rssivalidation.BleViewModel viewModel;
    private final kotlin.Lazy bluetoothAdapter$delegate = null;
    private final com.example.rssivalidation.SerivcesBle.BluServiceBinder binder = null;
    private final android.content.BroadcastReceiver receive = null;
    
    public SerivcesBle() {
        super();
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.aptener.bluconnect.device.C30 getDevice() {
        return null;
    }
    
    public final void setDevice(@org.jetbrains.annotations.Nullable
    com.aptener.bluconnect.device.C30 p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<com.aptener.bluconnect.device.sxcontrol.DeviceInfo.DeviceDetails> getDeviceInfo() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<com.aptener.bluconnect.device.BluArmorDevice> getActiveDevice() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<com.aptener.bluconnect.client.ConnectionState> getConnectionState() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<java.lang.String> getRidegridMacAddress() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<java.util.List<com.example.rssivalidation.RideGridUserDetails>> getRideGridRiders() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<com.aptener.bluconnect.device.sxcontrol.RideGrid.RideGridState> getRideGridState() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getRIDEGRID_MAC_ADDRESS() {
        return null;
    }
    
    public final int getRssiRidegrid() {
        return 0;
    }
    
    public final void setRssiRidegrid(int p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final android.bluetooth.le.ScanCallback getLeScanCallback() {
        return null;
    }
    
    public final void setLeScanCallback(@org.jetbrains.annotations.NotNull
    android.bluetooth.le.ScanCallback p0) {
    }
    
    private final android.bluetooth.BluetoothAdapter getBluetoothAdapter() {
        return null;
    }
    
    @java.lang.Override
    public int onStartCommand(@org.jetbrains.annotations.Nullable
    android.content.Intent intent, int flags, int startId) {
        return 0;
    }
    
    @androidx.annotation.RequiresApi(value = android.os.Build.VERSION_CODES.O)
    @android.annotation.SuppressLint(value = {"ForegroundServiceType"})
    @java.lang.Override
    public void onCreate() {
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public android.os.IBinder onBind(@org.jetbrains.annotations.NotNull
    android.content.Intent intent) {
        return null;
    }
    
    @java.lang.Override
    public void onBluArmorDeviceDiscovered(@org.jetbrains.annotations.NotNull
    java.util.Set<com.aptener.bluconnect.device.AdvertisingBluArmorDevice> result) {
    }
    
    private final void rideGridObserver(com.aptener.bluconnect.device.sxcontrol.RideGrid.RideGridState rideGridState) {
    }
    
    @androidx.annotation.RequiresApi(value = android.os.Build.VERSION_CODES.TIRAMISU)
    @java.lang.Override
    public void onConnectionStateChange(@org.jetbrains.annotations.NotNull
    com.aptener.bluconnect.client.ConnectionState state) {
    }
    
    @android.annotation.SuppressLint(value = {"MissingPermission"})
    private final void onDeviceReady(com.aptener.bluconnect.device.C30 c30) {
    }
    
    private final void deviceInfoObserver(com.aptener.bluconnect.device.sxcontrol.DeviceInfo.DeviceDetails deviceDetails) {
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
    
    @android.annotation.SuppressLint(value = {"MissingPermission"})
    public final void startBleScanner(@org.jetbrains.annotations.NotNull
    java.util.List<android.bluetooth.le.ScanFilter> scanFilters, @org.jetbrains.annotations.NotNull
    android.bluetooth.le.ScanSettings scanSettings) {
    }
    
    @android.annotation.SuppressLint(value = {"MissingPermission"})
    public final void stopBleScanner() {
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u00048F\u00a2\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/example/rssivalidation/SerivcesBle$BluServiceBinder;", "Landroid/os/Binder;", "(Lcom/example/rssivalidation/SerivcesBle;)V", "service", "Lcom/example/rssivalidation/SerivcesBle;", "getService", "()Lcom/example/rssivalidation/SerivcesBle;", "app_debug"})
    public final class BluServiceBinder extends android.os.Binder {
        
        public BluServiceBinder() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.example.rssivalidation.SerivcesBle getService() {
            return null;
        }
    }
}