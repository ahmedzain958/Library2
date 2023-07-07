package com.example.library2.googlelibraries

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import com.example.library2.R
import com.google.android.recaptcha.Recaptcha
import com.google.android.recaptcha.RecaptchaAction
import com.google.android.recaptcha.RecaptchaClient
import kotlinx.coroutines.launch

class RecaptchaGoogleActivity : AppCompatActivity() {
    private lateinit var recaptchaClient: RecaptchaClient
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recaptcha_google)
        initializeRecaptchaClient()
        findViewById<Button>(R.id.button22).setOnClickListener {
            executeLoginAction()
        }
    }


    private fun initializeRecaptchaClient() {
        lifecycleScope.launch {
            Recaptcha.getClient(application, "6LdjG7kmAAAAAMY3Tvlyco2QT8t70--0xJtwAshp")
                .onSuccess { client ->
                    recaptchaClient = client
                    Toast.makeText(this@RecaptchaGoogleActivity, "su", Toast.LENGTH_SHORT).show()

                }
                .onFailure { exception ->
                    // Handle communication errors ...
                    // See "Handle communication errors" section
                    Toast.makeText(this@RecaptchaGoogleActivity, "fa", Toast.LENGTH_SHORT).show()
                }
        }
    }
    private fun executeLoginAction() {
        lifecycleScope.launch {
            recaptchaClient
                .execute(RecaptchaAction.LOGIN)
                .onSuccess { token ->
                    // Handle success ...
                    // See "What's next" section for instructions
                    // about handling tokens.
                    Toast.makeText(this@RecaptchaGoogleActivity, "su", Toast.LENGTH_SHORT).show()
                }
                .onFailure { exception ->
                    // Handle communication errors ...
                    Toast.makeText(this@RecaptchaGoogleActivity, "fa", Toast.LENGTH_SHORT).show()
                    // See "Handle communication errors" section
                }
        }
    }
}