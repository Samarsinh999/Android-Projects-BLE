package com.example.rssivalidation;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0003J\u0018\u0010\u0007\u001a\n \t*\u0004\u0018\u00010\b0\b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u0006H\u0002\u00a8\u0006\u000f"}, d2 = {"Lcom/example/rssivalidation/NotifyDeviceState;", "", "()V", "createNotificationChannel", "", "context", "Landroid/content/Context;", "getDefaultPendingIntent", "Landroid/app/PendingIntent;", "kotlin.jvm.PlatformType", "getNotificationBuilder", "Landroid/app/Notification$Builder;", "notificationActionIntent", "Landroid/content/Intent;", "Companion", "app_debug"})
public final class NotifyDeviceState {
    @org.jetbrains.annotations.NotNull
    public static final com.example.rssivalidation.NotifyDeviceState.Companion Companion = null;
    public static final int NOTIFICATION_ID = 1001;
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String NOTIFICATION_ACTION = "1001";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String NOTIFICATION_ACTION_KEY = "NOTIFICATION_ACTION_KEY";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String NOTIFICATION_ACTION_EXIT = "EXIT";
    private static final java.lang.String NOTIFICATION_ACTION_OK = "OK";
    private static final java.lang.String NOTIFICATION_ACTION_CANCEL = "CANCEL";
    
    public NotifyDeviceState() {
        super();
    }
    
    private final android.content.Intent notificationActionIntent(android.content.Context context) {
        return null;
    }
    
    @androidx.annotation.RequiresApi(value = android.os.Build.VERSION_CODES.O)
    private final void createNotificationChannel(android.content.Context context) {
    }
    
    private final android.app.PendingIntent getDefaultPendingIntent(android.content.Context context) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @androidx.annotation.RequiresApi(value = android.os.Build.VERSION_CODES.O)
    public final android.app.Notification.Builder getNotificationBuilder(@org.jetbrains.annotations.NotNull
    android.content.Context context) {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2 = {"Lcom/example/rssivalidation/NotifyDeviceState$Companion;", "", "()V", "NOTIFICATION_ACTION", "", "NOTIFICATION_ACTION_CANCEL", "NOTIFICATION_ACTION_EXIT", "NOTIFICATION_ACTION_KEY", "NOTIFICATION_ACTION_OK", "NOTIFICATION_ID", "", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}