package com.example.library2.googlelibraries

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.library2.R

class SafetyNetRecaptchaActivity : AppCompatActivity() {
    companion object{
        private val RECAPTCHA_KEY = "6LdjG7kmAAAAAMY3Tvlyco2QT8t70--0xJtwAshp"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_safety_net_recaptcha)
    }
}