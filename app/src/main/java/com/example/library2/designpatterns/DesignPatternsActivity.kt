package com.example.library2.designpatterns

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.library2.R
import com.example.library2.common.CommonList
import com.example.library2.designpatterns.headfirstver2.inheritanceissues.DisadvantagesOfInheritanceActivity
import com.example.library2.designpatterns.linkedin.LikedInFoundationsDesignPatternsActivity

class DesignPatternsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_design_patterns)
        val items = listOf(
            "LikedIn DesignPatterns Foundations Activity" to LikedInFoundationsDesignPatternsActivity::class.java,
            "Disadvantages of inheritance Head First v2" to DisadvantagesOfInheritanceActivity::class.java
        )
        val commonList = findViewById<CommonList>(R.id.commonList)

        commonList.updateData(activityItemsList = items)

    }
}