package com.ontime.app.auth

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import com.ontime.app.HomeActivity
import com.ontime.app.R
import com.ontime.app.databinding.ActivityLoginBinding

private const val TAG = "LoginActivity"

/**
 * Screen 2: Login.
 *
 * Two ways in: email + password (Firebase Authentication hashes and
 * stores the password) or single sign-on with Google, which is linked
 * to the same Firebase account system.
 */
class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private val auth by lazy { FirebaseAuth.getInstance() }

    private val googleLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            handleGoogleResult(result.data)
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonLogin.setOnClickListener { attemptLogin() }
        binding.buttonGoogle.setOnClickListener { startGoogleSignIn() }
        binding.textGoRegister.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }
    }

    private fun attemptLogin() {
        val email = binding.inputEmail.text?.toString()?.trim().orEmpty()
        val password = binding.inputPassword.text?.toString().orEmpty()

        if (email.isEmpty() || password.isEmpty()) {
            showError(getString(R.string.error_fill_all_fields))
            return
        }
        hideError()
        setLoading(true)
        Log.d(TAG, "Login attempt for $email")

        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                setLoading(false)
                if (task.isSuccessful) {
                    Log.d(TAG, "Login successful for $email")
                    goHome()
                } else {
                    Log.w(TAG, "Login failed for $email", task.exception)
                    showError(getString(R.string.error_invalid_login))
                }
            }
    }

    private fun startGoogleSignIn() {
        // default_web_client_id is generated from google-services.json once Google
        // sign-in is enabled in the Firebase console - look it up safely so the app
        // still builds and shows a friendly message if that step hasn't been done.
        val clientIdRes = resources.getIdentifier("default_web_client_id", "string", packageName)
        if (clientIdRes == 0) {
            Log.e(TAG, "default_web_client_id is missing - enable Google sign-in and re-download google-services.json")
            showError(getString(R.string.error_google_not_configured))
            return
        }

        val options = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(clientIdRes))
            .requestEmail()
            .build()
        val client = GoogleSignIn.getClient(this, options)

        hideError()
        Log.d(TAG, "Starting Google sign-in")
        // Sign out first so the account chooser always appears.
        client.signOut().addOnCompleteListener {
            googleLauncher.launch(client.signInIntent)
        }
    }

    private fun handleGoogleResult(data: Intent?) {
        val task = GoogleSignIn.getSignedInAccountFromIntent(data)
        try {
            val account = task.getResult(ApiException::class.java)
            val idToken = account.idToken
            if (idToken == null) {
                Log.e(TAG, "Google returned no ID token")
                showError(getString(R.string.error_google_failed, -1))
                return
            }
            setLoading(true)
            val credential = GoogleAuthProvider.getCredential(idToken, null)
            auth.signInWithCredential(credential).addOnCompleteListener { signIn ->
                setLoading(false)
                if (signIn.isSuccessful) {
                    Log.d(TAG, "Google sign-in successful for ${auth.currentUser?.email}")
                    goHome()
                } else {
                    Log.w(TAG, "Firebase rejected the Google credential", signIn.exception)
                    showError(getString(R.string.error_google_failed, -2))
                }
            }
        } catch (e: ApiException) {
            Log.e(TAG, "Google sign-in failed, code=${e.statusCode}", e)
            showError(getString(R.string.error_google_failed, e.statusCode))
        }
    }

    private fun goHome() {
        startActivity(Intent(this, HomeActivity::class.java))
        finish()
    }

    private fun setLoading(loading: Boolean) {
        binding.buttonLogin.isEnabled = !loading
        binding.buttonGoogle.isEnabled = !loading
        binding.buttonLogin.text = if (loading)
            getString(R.string.loading) else getString(R.string.action_login)
    }

    private fun showError(message: String) {
        binding.textLoginError.text = message
        binding.textLoginError.visibility = View.VISIBLE
    }

    private fun hideError() {
        binding.textLoginError.visibility = View.GONE
    }
}
