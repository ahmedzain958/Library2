package com.example.library2.oop

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.library2.R
import com.example.library2.common.CommonList
import com.example.library2.designpatterns.linkedin.LikedInFoundationsDesignPatternsActivity

class OOPActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_oopactivity)
        val items = listOf(
            "Concrete Class" to ConcreteCLassActivity::class.java,
            "Strong vs Weak IS-A relationship " to StrongVsWeakISARelationship::class.java,
            "Interface Meaning" to InterfaceActivity::class.java
        )
        val commonList = findViewById<CommonList>(R.id.commonList)

        commonList.updateData(activityItemsList = items)
    }
}