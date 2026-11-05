package com.ontime.app.settings

import android.Manifest
import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.os.LocaleListCompat
import androidx.lifecycle.lifecycleScope
import com.google.firebase.messaging.FirebaseMessaging
import com.ontime.app.R
import com.ontime.app.databinding.ActivitySettingsBinding
import com.ontime.app.logic.AppLanguage
import com.ontime.app.notifications.NotificationHelper
import com.ontime.app.util.LocalPrefs
import kotlinx.coroutines.launch

private const val TAG = "SettingsActivity"

/**
 * Screen 8: Settings.
 *
 * Default duration, theme (light/dark), language (English, isiZulu,
 * isiXhosa), reminder notifications, plus buttons to test push
 * notifications. Saved on the phone (works offline) and to Firestore
 * through the REST API.
 */
class SettingsActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySettingsBinding
    private val repository by lazy { SettingsRepository(applicationContext) }

    private val permissionLauncher =
        registerForActivityResult(ActivityResultContracts.RequestPermission()) { granted ->
            Log.d(TAG, "Notification permission granted=$granted")
            if (granted) sendTestNotification()
            else showStatus(getString(R.string.settings_notification_permission), isError = true)
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySettingsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        showSettings(repository.loadLocal())
        loadSettings()

        binding.buttonSaveSettings.setOnClickListener { saveSettings() }
        binding.buttonTestNotification.setOnClickListener { onTestNotificationClicked() }
        binding.buttonShowToken.setOnClickListener { copyPushToken() }
    }

    private fun loadSettings() {
        setLoading(true)
        lifecycleScope.launch {
            val settings = repository.load()
            showSettings(settings)
            setLoading(false)
        }
    }

    private fun showSettings(settings: UserSettings) {
        binding.inputDuration.setText(settings.defaultDurationMinutes.toString())
        binding.inputReminderMinutes.setText(settings.reminderMinutes.toString())
        binding.switchNotifications.isChecked = settings.notificationsEnabled

        if (settings.theme == "Dark") binding.radioDark.isChecked = true
        else binding.radioLight.isChecked = true

        when (AppLanguage.fromTag(settings.language)) {
            AppLanguage.ZULU -> binding.radioZulu.isChecked = true
            AppLanguage.XHOSA -> binding.radioXhosa.isChecked = true
            AppLanguage.ENGLISH -> binding.radioEnglish.isChecked = true
        }
    }

    private fun selectedLanguage(): AppLanguage = when {
        binding.radioZulu.isChecked -> AppLanguage.ZULU
        binding.radioXhosa.isChecked -> AppLanguage.XHOSA
        else -> AppLanguage.ENGLISH
    }

    private fun saveSettings() {
        val minutes = binding.inputDuration.text?.toString()?.toIntOrNull()
        if (minutes == null || minutes <= 0) {
            showStatus(getString(R.string.settings_invalid_duration), isError = true)
            return
        }
        val reminder = binding.inputReminderMinutes.text?.toString()?.toIntOrNull()
        if (reminder == null || reminder < 0) {
            showStatus(getString(R.string.settings_invalid_reminder), isError = true)
            return
        }

        val settings = UserSettings(
            defaultDurationMinutes = minutes,
            theme = if (binding.radioDark.isChecked) "Dark" else "Light",
            language = selectedLanguage().tag,
            notificationsEnabled = binding.switchNotifications.isChecked,
            reminderMinutes = reminder
        )
        Log.d(TAG, "Saving settings: $settings")

        setLoading(true)
        lifecycleScope.launch {
            val uploaded = repository.save(settings)
            showStatus(
                getString(if (uploaded) R.string.settings_saved else R.string.settings_saved_offline),
                isError = false
            )
            setLoading(false)
            applyAppearance(settings)
        }
    }

    /** Switches theme and language straight away. Android recreates the screens, so this runs last. */
    private fun applyAppearance(settings: UserSettings) {
        AppCompatDelegate.setDefaultNightMode(
            if (settings.theme == "Dark") AppCompatDelegate.MODE_NIGHT_YES
            else AppCompatDelegate.MODE_NIGHT_NO
        )
        val currentTags = AppCompatDelegate.getApplicationLocales().toLanguageTags()
        if (currentTags != settings.language) {
            Log.d(TAG, "Changing app language to ${settings.language}")
            AppCompatDelegate.setApplicationLocales(LocaleListCompat.forLanguageTags(settings.language))
        }
    }

    private fun onTestNotificationClicked() {
        if (NotificationHelper.hasPermission(this)) {
            sendTestNotification()
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            permissionLauncher.launch(Manifest.permission.POST_NOTIFICATIONS)
        }
    }

    private fun sendTestNotification() {
        NotificationHelper.show(
            this,
            getString(R.string.app_name),
            getString(R.string.test_notification_body),
            1001
        )
    }

    private fun copyPushToken() {
        FirebaseMessaging.getInstance().token.addOnCompleteListener { task ->
            if (!task.isSuccessful) {
                Log.w(TAG, "Couldn't get the push token", task.exception)
                showStatus(getString(R.string.settings_token_failed), isError = true)
                return@addOnCompleteListener
            }
            val token = task.result
            Log.d(TAG, "Push token: $token")
            LocalPrefs(this).fcmToken = token
            val clipboard = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
            clipboard.setPrimaryClip(ClipData.newPlainText("push token", token))
            Toast.makeText(this, R.string.settings_token_copied, Toast.LENGTH_LONG).show()
        }
    }

    private fun setLoading(loading: Boolean) {
        binding.progressSettings.visibility = if (loading) View.VISIBLE else View.GONE
        binding.buttonSaveSettings.isEnabled = !loading
    }

    private fun showStatus(message: String, isError: Boolean) {
        binding.textSettingsStatus.text = message
        binding.textSettingsStatus.setTextColor(
            getColor(if (isError) R.color.importance_high else R.color.importance_low)
        )
        binding.textSettingsStatus.visibility = View.VISIBLE
    }
}
