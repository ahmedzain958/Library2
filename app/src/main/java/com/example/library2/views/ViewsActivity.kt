package com.example.library2.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.library2.R
import com.example.library2.common.CommonList
import com.example.library2.views.animatedviews.lottie.LottieViewActivity
import com.example.library2.views.recyclerview_expandable.ExpandableRecyclerActivity
import com.example.library2.views.viewtreeobserver.ViewTreeObserverActivity

class ViewsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_views)
        val items = listOf(
            "Lottie view on Button" to LottieViewActivity::class.java,
            "ViewTreeObserverActivity" to ViewTreeObserverActivity::class.java,
            "ExpandableRecyclerActivity" to ExpandableRecyclerActivity::class.java
        )

        val commonList = findViewById<CommonList>(R.id.commonList)

        commonList.updateData(activityItemsList = items)
    }
}