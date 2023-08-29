package com.example.library2.architectures

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.library2.R
import com.example.library2.architectures.mvi.nerds.MVINerdsAddNumerActivity
import com.example.library2.common.CommonList
import com.example.library2.concurrentprogramming.coroutines.CoroutinesExceptionActivity
import com.example.library2.concurrentprogramming.coroutines.nerds.CoroutineBuilderComponentsActivity
import com.example.library2.coroutines_flows.FlowsPhilipActivity
import com.example.library2.coroutines_flows.nerds.CollectCalledFromSuspend_NoEmissionWithoutCollect_Activity
import com.example.library2.coroutines_flows.nerds.CollectorConfirmsFlowEmissionActivity
import com.example.library2.coroutines_flows.nerds.LiveDataVsStateFlowActivity
import com.example.library2.coroutines_flows.nerds.ZipFlowsActivity

class ArchitecturesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_architectures)
        val items = listOf(
            "MVI Nerds AddNumber Activity" to MVINerdsAddNumerActivity::class.java,
        )
        val commonList = findViewById<CommonList>(R.id.commonList)

        commonList.updateData(activityItemsList = items)
    }
}