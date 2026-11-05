package com.ontime.app

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import android.net.Network
import android.util.Log
import androidx.appcompat.app.AppCompatDelegate
import com.ontime.app.notifications.NotificationHelper
import com.ontime.app.sync.SyncManager
import com.ontime.app.util.LocalPrefs
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch

/**
 * App-wide setup: applies the saved theme, creates the notification
 * channel, and starts a sync whenever the phone regains a connection
 * (this is the "synchronise once they reconnect" part of offline mode).
 */
class OnTimeApp : Application() {

    private val appScope = CoroutineScope(SupervisorJob() + Dispatchers.IO)

    override fun onCreate() {
        super.onCreate()

        val nightMode = if (LocalPrefs(this).theme == "Dark") {
            AppCompatDelegate.MODE_NIGHT_YES
        } else {
            AppCompatDelegate.MODE_NIGHT_NO
        }
        AppCompatDelegate.setDefaultNightMode(nightMode)

        NotificationHelper.createChannel(this)
        registerNetworkCallback()
    }

    private fun registerNetworkCallback() {
        try {
            val connectivityManager = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            connectivityManager.registerDefaultNetworkCallback(object : ConnectivityManager.NetworkCallback() {
                override fun onAvailable(network: Network) {
                    Log.d(TAG, "Network available - syncing offline changes")
                    appScope.launch { SyncManager.syncIfLoggedIn(applicationContext) }
                }
            })
        } catch (e: Exception) {
            Log.e(TAG, "Couldn't register the network callback", e)
        }
    }

    companion object {
        private const val TAG = "OnTimeApp"
    }
}
