package com.example.library2.withnavcomponent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.library2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(ActivityMainBinding.inflate(layoutInflater).root)
    }
}