package com.example.library2.compose

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.library2.R
import com.example.library2.common.CommonList
import com.example.library2.compose.interoperability.ComposeInteroperabilityMitchActivity

class ComposeActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_compose)
        val items = listOf(
            "Interoperability Activity Contains Fragment ComposeInteroperabilityMitchActivity" to ComposeInteroperabilityMitchActivity::class.java,
        )
        val commonList = findViewById<CommonList>(R.id.commonList)

        commonList.updateData(activityItemsList = items)
    }
}