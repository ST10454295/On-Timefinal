package com.ontime.app

import android.Manifest
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ArrayAdapter
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.messaging.FirebaseMessaging
import com.ontime.app.activities.ActivityFormatter
import com.ontime.app.activities.ActivityRepository
import com.ontime.app.activities.AddActivityActivity
import com.ontime.app.auth.LoginActivity
import com.ontime.app.calendar.CalendarActivity
import com.ontime.app.databinding.ActivityHomeBinding
import com.ontime.app.notifications.FcmTokenStore
import com.ontime.app.notifications.NotificationHelper
import com.ontime.app.settings.SettingsActivity
import com.ontime.app.util.LocalPrefs
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

private const val TAG = "HomeActivity"

/**
 * Screen 4: Dashboard.
 *
 * Shows today's activities (read from the local Room database, so it
 * works offline), how many are still waiting to sync, and links to Add
 * Activity, Calendar, Settings and Log Out. Also asks for the
 * notification permission and registers this phone for push messages.
 */
class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding
    private val repository by lazy { ActivityRepository(applicationContext) }
    private lateinit var listAdapter: ArrayAdapter<String>

    private val permissionLauncher =
        registerForActivityResult(ActivityResultContracts.RequestPermission()) { granted ->
            Log.d(TAG, "Notification permission granted=$granted")
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        FirebaseAuth.getInstance().currentUser?.displayName?.let { name ->
            if (name.isNotBlank()) {
                binding.textGreeting.text = getString(R.string.home_greeting, name)
            }
        }

        listAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, mutableListOf())
        binding.listToday.adapter = listAdapter

        binding.buttonAddActivity.setOnClickListener {
            startActivity(Intent(this, AddActivityActivity::class.java))
        }
        binding.buttonCalendar.setOnClickListener {
            startActivity(Intent(this, CalendarActivity::class.java))
        }
        binding.buttonSettings.setOnClickListener {
            startActivity(Intent(this, SettingsActivity::class.java))
        }
        binding.buttonLogout.setOnClickListener {
            Log.d(TAG, "User logged out")
            FirebaseAuth.getInstance().signOut()
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }

        requestNotificationPermission()
        registerPushToken()
    }

    override fun onResume() {
        super.onResume()
        lifecycleScope.launch {
            showToday()
            repository.syncNow()
            showToday()
        }
    }

    private suspend fun showToday() {
        try {
            val today = SimpleDateFormat("yyyy-MM-dd", Locale.US).format(Date())
            val items = repository.listForDate(today)
            listAdapter.clear()
            listAdapter.addAll(items.map { ActivityFormatter.line(this, it, includeDate = false) })
            binding.textEmpty.visibility = if (items.isEmpty()) View.VISIBLE else View.GONE

            val pending = repository.pendingCount()
            binding.textSyncStatus.text = if (pending == 0) {
                getString(R.string.sync_status_synced)
            } else {
                getString(R.string.sync_status_pending, pending)
            }
        } catch (e: Exception) {
            Log.e(TAG, "Couldn't load today's activities", e)
        }
    }

    private fun requestNotificationPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU && !NotificationHelper.hasPermission(this)) {
            permissionLauncher.launch(Manifest.permission.POST_NOTIFICATIONS)
        }
    }

    private fun registerPushToken() {
        FirebaseMessaging.getInstance().token.addOnCompleteListener { task ->
            if (!task.isSuccessful) {
                Log.w(TAG, "Couldn't get the push token", task.exception)
                return@addOnCompleteListener
            }
            val token = task.result
            Log.d(TAG, "Push token: $token")
            LocalPrefs(this).fcmToken = token
            lifecycleScope.launch { FcmTokenStore.saveForCurrentUser(token) }
        }
    }
}
