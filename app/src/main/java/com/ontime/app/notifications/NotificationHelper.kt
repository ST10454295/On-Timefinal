package com.ontime.app.notifications

import android.Manifest
import android.annotation.SuppressLint
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.util.Log
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.core.content.ContextCompat
import com.ontime.app.R
import com.ontime.app.SplashActivity

/** Creates the notification channel and shows notifications (reminders, push messages, test). */
object NotificationHelper {

    private const val TAG = "NotificationHelper"
    const val CHANNEL_ID = "ontime_reminders"

    fun createChannel(context: Context) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                CHANNEL_ID,
                context.getString(R.string.notification_channel_name),
                NotificationManager.IMPORTANCE_HIGH
            )
            val manager = context.getSystemService(NotificationManager::class.java)
            manager.createNotificationChannel(channel)
        }
    }

    fun hasPermission(context: Context): Boolean {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.TIRAMISU) return true
        return ContextCompat.checkSelfPermission(
            context, Manifest.permission.POST_NOTIFICATIONS
        ) == PackageManager.PERMISSION_GRANTED
    }

    @SuppressLint("MissingPermission")
    fun show(context: Context, title: String, body: String, notificationId: Int) {
        if (!hasPermission(context)) {
            Log.w(TAG, "Notification permission not granted - not showing '$title'")
            return
        }
        createChannel(context)

        val openApp = PendingIntent.getActivity(
            context,
            0,
            Intent(context, SplashActivity::class.java),
            PendingIntent.FLAG_IMMUTABLE or PendingIntent.FLAG_UPDATE_CURRENT
        )

        val notification = NotificationCompat.Builder(context, CHANNEL_ID)
            .setSmallIcon(R.drawable.ic_notification)
            .setContentTitle(title)
            .setContentText(body)
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setAutoCancel(true)
            .setContentIntent(openApp)
            .build()

        NotificationManagerCompat.from(context).notify(notificationId, notification)
        Log.d(TAG, "Notification shown: $title - $body")
    }
}
