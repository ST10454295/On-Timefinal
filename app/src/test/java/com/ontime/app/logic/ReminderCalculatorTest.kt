package com.ontime.app.logic

import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Test
import java.text.SimpleDateFormat
import java.util.Locale

class ReminderCalculatorTest {

    private val format = SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.US)
    private fun millis(text: String): Long = format.parse(text)!!.time

    @Test
    fun `reminder fires the chosen number of minutes before the start`() {
        val now = millis("2026-11-05 08:00")

        val result = ReminderCalculator.triggerTimeMillis("2026-11-05", "10:00", 15, now)

        assertEquals(millis("2026-11-05 09:45"), result)
    }

    @Test
    fun `zero minutes means the reminder fires at the start time`() {
        val now = millis("2026-11-05 08:00")

        val result = ReminderCalculator.triggerTimeMillis("2026-11-05", "10:00", 0, now)

        assertEquals(millis("2026-11-05 10:00"), result)
    }

    @Test
    fun `no reminder when the reminder time has already passed`() {
        val now = millis("2026-11-05 09:50")

        val result = ReminderCalculator.triggerTimeMillis("2026-11-05", "10:00", 15, now)

        assertNull(result)
    }

    @Test
    fun `no reminder for a malformed date or time instead of crashing`() {
        val now = millis("2026-11-05 08:00")

        assertNull(ReminderCalculator.triggerTimeMillis("not a date", "10:00", 15, now))
        assertNull(ReminderCalculator.triggerTimeMillis("2026-11-05", "25:00", 15, now))
        assertNull(ReminderCalculator.triggerTimeMillis("2026-13-45", "10:00", 15, now))
    }

    @Test
    fun `negative reminder minutes are rejected`() {
        val now = millis("2026-11-05 08:00")

        assertNull(ReminderCalculator.triggerTimeMillis("2026-11-05", "10:00", -5, now))
    }
}
