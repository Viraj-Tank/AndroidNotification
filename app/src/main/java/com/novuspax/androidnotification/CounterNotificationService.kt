package com.novuspax.androidnotification

import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import androidx.core.app.NotificationCompat

class CounterNotificationService(
    private val context: Context
) {
    private val notificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

    /** in realtime project we can override this
     *  function using interface something
     **/
    fun showNotification(counter: Int) {

        val activityIntent = Intent(context, MainActivity::class.java)

        val activityPendingIntent = PendingIntent.getActivity(
            context,
            1,
            activityIntent,
            PendingIntent.FLAG_IMMUTABLE
        )

        val incrementIntent = PendingIntent.getBroadcast(
            context,
            2,
            Intent(context,CounterNotificationReceiver::class.java),
            PendingIntent.FLAG_IMMUTABLE
        )

        val notification = NotificationCompat.Builder(context, COUNTER_CHANNEL_ID)
            .setSmallIcon(R.drawable.ic_notification)
            .setContentTitle("Increment Counter")
            .setContentText("counter $counter")
            .setStyle(NotificationCompat.BigTextStyle())   //set diff style of notification
            .setContentIntent(activityPendingIntent)
            .addAction(
                R.drawable.ic_notification,
                "Increment",
                incrementIntent
                )
            .build()

        notificationManager.notify(1,notification)

    }

    companion object {
        const val COUNTER_CHANNEL_ID = "counter_channel"
    }
}