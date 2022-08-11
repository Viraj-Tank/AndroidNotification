package com.novuspax.androidnotification

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context

class BaseApp : Application() {
    override fun onCreate() {
        super.onCreate()
        createNotificationChannel()
    }

    private fun createNotificationChannel() {
        val channel = NotificationChannel(
            CounterNotificationService.COUNTER_CHANNEL_ID,
            "Counter",
            NotificationManager.IMPORTANCE_DEFAULT
        )
        channel.description = "Used to increment counter in notification"

        // we can context here from application class so need to write context.getSystemService
        val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.createNotificationChannel(channel)
    }
}