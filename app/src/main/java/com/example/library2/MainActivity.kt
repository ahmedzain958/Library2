package com.example.library2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.library2.common.CommonList
import com.example.library2.views.animatedviews.lottie.LottieViewActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val items = listOf(
            "Views" to LottieViewActivity::class.java
        )

        val commonList = findViewById<CommonList>(R.id.commonList)

        commonList.updateData(activityItemsList = items)
    }

}