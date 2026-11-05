package com.ontime.app.notifications

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.ontime.app.R

/** Fires when a scheduled reminder is due and shows the notification. */
class ReminderReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        val title = intent.getStringExtra(ReminderScheduler.EXTRA_TITLE) ?: return
        val start = intent.getStringExtra(ReminderScheduler.EXTRA_START) ?: ""
        NotificationHelper.show(
            context,
            title,
            context.getString(R.string.reminder_body, start),
            System.currentTimeMillis().toInt()
        )
    }
}
