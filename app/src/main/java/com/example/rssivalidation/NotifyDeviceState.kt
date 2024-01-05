package com.example.rssivalidation

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.Service
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.annotation.RequiresApi

class NotifyDeviceState {
    companion object {
        const val NOTIFICATION_ID = 1001
        const val NOTIFICATION_ACTION = "1001"
        const val NOTIFICATION_ACTION_KEY = "NOTIFICATION_ACTION_KEY"
        const val NOTIFICATION_ACTION_EXIT = "EXIT"
        private const val NOTIFICATION_ACTION_OK = "OK"
        private const val NOTIFICATION_ACTION_CANCEL = "CANCEL"
    }

    private fun notificationActionIntent(context: Context) =
        Intent(NOTIFICATION_ACTION, null, context, SerivcesBle::class.java)

    @RequiresApi(Build.VERSION_CODES.O)
    private fun createNotificationChannel(context: Context) {
        with(context.getSystemService(Service.NOTIFICATION_SERVICE) as NotificationManager) {
            createNotificationChannel(
                NotificationChannel(
                    context.getString(R.string.channel_device_id),
                    context.getString(R.string.channel_device),
                    NotificationManager.IMPORTANCE_LOW
                ).apply { description = context.getString(R.string.channel_device_description) }
            )
        }
    }

    private fun getDefaultPendingIntent(context: Context) =
        PendingIntent.getActivity(
            context,
            0,
            Intent(context, MainActivity::class.java),
            PendingIntent.FLAG_IMMUTABLE
        )

    @RequiresApi(Build.VERSION_CODES.O)
    fun getNotificationBuilder(context: Context): Notification.Builder {
        createNotificationChannel(context)

        return Notification.Builder(context, context.getString(R.string.channel_device_id))
            .setCategory(Notification.CATEGORY_SERVICE)
            .setSmallIcon(R.drawable.ic_ok)
            .setContentIntent(getDefaultPendingIntent(context))
            .setTicker(context.getString(R.string.app_name))
    }
}