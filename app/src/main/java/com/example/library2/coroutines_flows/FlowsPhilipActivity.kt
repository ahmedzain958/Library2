package com.example.library2.coroutines_flows

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.library2.R
import com.example.library2.coroutines_flows.ui.main.FlowsPhilipFragment

class FlowsPhilipActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_flows_philip)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, FlowsPhilipFragment.newInstance())
                .commitNow()
        }
    }
}