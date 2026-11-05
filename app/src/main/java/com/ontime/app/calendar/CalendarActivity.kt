package com.ontime.app.calendar

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.ontime.app.activities.ActivityFormatter
import com.ontime.app.activities.ActivityRepository
import com.ontime.app.databinding.ActivityCalendarBinding
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

private const val TAG = "CalendarActivity"

/**
 * Screen 7: Calendar.
 *
 * Pick a day to see that day's activities. Reads from the local Room
 * database, so it also works offline.
 */
class CalendarActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCalendarBinding
    private val repository by lazy { ActivityRepository(applicationContext) }
    private lateinit var listAdapter: ArrayAdapter<String>
    private val dateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.US)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCalendarBinding.inflate(layoutInflater)
        setContentView(binding.root)

        listAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, mutableListOf())
        binding.listDay.adapter = listAdapter

        binding.calendarView.setOnDateChangeListener { _, year, month, dayOfMonth ->
            val date = String.format(Locale.US, "%04d-%02d-%02d", year, month + 1, dayOfMonth)
            Log.d(TAG, "Selected date $date")
            showDay(date)
        }

        showDay(dateFormat.format(Date()))
    }

    private fun showDay(date: String) {
        binding.textSelectedDate.text = date
        lifecycleScope.launch {
            try {
                val items = repository.listForDate(date)
                listAdapter.clear()
                listAdapter.addAll(items.map { ActivityFormatter.line(this@CalendarActivity, it, includeDate = false) })
                binding.textCalendarEmpty.visibility = if (items.isEmpty()) View.VISIBLE else View.GONE
            } catch (e: Exception) {
                Log.e(TAG, "Couldn't load activities for $date", e)
            }
        }
    }
}
