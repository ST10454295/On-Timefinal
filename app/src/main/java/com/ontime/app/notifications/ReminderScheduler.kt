package com.ontime.app.notifications

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.util.Log
import com.ontime.app.logic.ReminderCalculator
import com.ontime.app.util.LocalPrefs

/**
 * Schedules a reminder notification before an activity starts, using the
 * "minutes before" value from Settings. Uses an inexact alarm, which
 * needs no special permission.
 */
object ReminderScheduler {

    private const val TAG = "ReminderScheduler"
    const val EXTRA_TITLE = "extra_title"
    const val EXTRA_START = "extra_start"

    fun schedule(context: Context, title: String, date: String, startTime: String) {
        val prefs = LocalPrefs(context)
        if (!prefs.notificationsEnabled) {
            Log.d(TAG, "Reminders are switched off in Settings - not scheduling '$title'")
            return
        }

        val triggerAt = ReminderCalculator.triggerTimeMillis(
            date, startTime, prefs.reminderMinutes, System.currentTimeMillis()
        )
        if (triggerAt == null) {
            Log.d(TAG, "No reminder for '$title' (time already passed or invalid)")
            return
        }

        val intent = Intent(context, ReminderReceiver::class.java).apply {
            putExtra(EXTRA_TITLE, title)
            putExtra(EXTRA_START, startTime)
        }
        val requestCode = (title + date + startTime).hashCode()
        val pendingIntent = PendingIntent.getBroadcast(
            context,
            requestCode,
            intent,
            PendingIntent.FLAG_IMMUTABLE or PendingIntent.FLAG_UPDATE_CURRENT
        )

        val alarmManager = context.getSystemService(Context.ALARM_SERVICE) as AlarmManager
        alarmManager.setAndAllowWhileIdle(AlarmManager.RTC_WAKEUP, triggerAt, pendingIntent)
        Log.d(TAG, "Reminder scheduled for '$title' at $triggerAt")
    }
}
