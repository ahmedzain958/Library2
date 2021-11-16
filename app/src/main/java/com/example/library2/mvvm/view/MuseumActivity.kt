package com.example.library2.mvvm.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.library2.R

class MuseumActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_museum)
        setupViewModel()
    }

    private fun setupViewModel() {

    }
}