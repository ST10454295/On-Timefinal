package com.ontime.app.logic

import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.Locale

/**
 * Works out when a reminder notification should fire. Plain Kotlin with
 * no Android dependencies, so it can be unit tested.
 */
object ReminderCalculator {

    /**
     * @return the time (epoch millis) to notify, or null if the date/time is
     * malformed or the reminder time has already passed.
     */
    fun triggerTimeMillis(
        date: String,
        startTime: String,
        minutesBefore: Int,
        nowMillis: Long
    ): Long? {
        if (minutesBefore < 0) return null
        val format = SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.US)
        format.isLenient = false
        val startMillis = try {
            format.parse("$date $startTime")?.time
        } catch (e: ParseException) {
            null
        } ?: return null

        val trigger = startMillis - minutesBefore * 60_000L
        return if (trigger <= nowMillis) null else trigger
    }
}
