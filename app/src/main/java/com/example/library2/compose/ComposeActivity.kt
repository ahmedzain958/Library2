package com.example.library2.compose

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.library2.R
import com.example.library2.common.CommonList
import com.example.library2.compose.recipemitch.RecipeMitchActivity

class ComposeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_compose)
        val items = listOf(
            "Recipe Mitch" to RecipeMitchActivity::class.java
        )
        val commonList = findViewById<CommonList>(R.id.commonList)

        commonList.updateData(activityItemsList = items)

    }
}