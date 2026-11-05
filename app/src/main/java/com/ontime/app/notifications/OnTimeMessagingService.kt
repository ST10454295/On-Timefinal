package com.ontime.app.notifications

import android.util.Log
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import com.ontime.app.R
import com.ontime.app.util.LocalPrefs
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch

/**
 * Receives push notifications from Firebase Cloud Messaging.
 * While the app is open the message is shown through onMessageReceived;
 * while it is closed Android shows it automatically.
 */
class OnTimeMessagingService : FirebaseMessagingService() {

    private val scope = CoroutineScope(SupervisorJob() + Dispatchers.IO)

    override fun onNewToken(token: String) {
        Log.d(TAG, "New push token: $token")
        LocalPrefs(this).fcmToken = token
        scope.launch { FcmTokenStore.saveForCurrentUser(token) }
    }

    override fun onMessageReceived(message: RemoteMessage) {
        val title = message.notification?.title
            ?: message.data["title"]
            ?: getString(R.string.app_name)
        val body = message.notification?.body ?: message.data["body"] ?: ""
        Log.d(TAG, "Push message received: $title - $body")
        NotificationHelper.show(this, title, body, System.currentTimeMillis().toInt())
    }

    companion object {
        private const val TAG = "OnTimeMessaging"
    }
}
