package com.example.library2.concurrentprogramming

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.library2.R
import com.example.library2.common.CommonList
import com.example.library2.concurrentprogramming.coroutines.CoroutinesExceptionActivity

class ConcurrentProgrammingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_views)
        val items = listOf(
            "coroutines exception with try and catch" to CoroutinesExceptionActivity::class.java
        )
        val commonList = findViewById<CommonList>(R.id.commonList)

        commonList.updateData(activityItemsList = items)
    }
}