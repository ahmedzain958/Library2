package com.example.library2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.library2.common.CommonList
//import com.example.library2.compose.ComposeActivity
import com.example.library2.concurrentprogramming.ConcurrentProgrammingActivity
import com.example.library2.designpatterns.DesignPatternsActivity
import com.example.library2.oop.OOPActivity
import com.example.library2.views.ViewsActivity
import com.example.library2.views.animatedviews.lottie.LottieViewActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val items = listOf(
            "Views" to ViewsActivity::class.java,
            "Concurrent Programming" to ConcurrentProgrammingActivity::class.java,
//            "Compose" to ComposeActivity::class.java,
            "Design Patterns" to DesignPatternsActivity::class.java,
            "OOP" to OOPActivity::class.java
        )

        val commonList = findViewById<CommonList>(R.id.commonList)

        commonList.updateData(activityItemsList = items)
    }

}