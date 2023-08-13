package com.example.library2.concurrentprogramming

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.library2.R
import com.example.library2.common.CommonList
import com.example.library2.concurrentprogramming.coroutines.CoroutinesExceptionActivity
import com.example.library2.concurrentprogramming.coroutines.nerds.CoroutineBuilderComponentsActivity
import com.example.library2.concurrentprogramming.flows.nerds.CollectorConfirmsFlowEmissionActivity
import com.example.library2.concurrentprogramming.flows.nerds.CollectCalledFromSuspend_NoEmissionWithoutCollect_Activity
import com.example.library2.coroutines_flows.FlowsPhilipActivity

class ConcurrentProgrammingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_views)
        val items = listOf(
            "coroutines exception with try and catch" to CoroutinesExceptionActivity::class.java,
            "CoroutineBuilderComponentsActivity" to CoroutineBuilderComponentsActivity::class.java,
            "CollectorConfirmsFlowEmissionActivity" to CollectorConfirmsFlowEmissionActivity::class.java,
            "FlowsPhilipActivity" to FlowsPhilipActivity::class.java,
            "CollectCalledFromSuspend_NoEmissionWithoutCollect_Activity" to CollectCalledFromSuspend_NoEmissionWithoutCollect_Activity::class.java,
            "CoroutineBuilderComponentsActivity" to CoroutineBuilderComponentsActivity::class.java,

        )
        val commonList = findViewById<CommonList>(R.id.commonList)

        commonList.updateData(activityItemsList = items)
    }
}