package com.example.library2.coroutines_flows.nerds

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.library2.R
import kotlinx.coroutines.launch

class LiveDataVsStateFlowActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_livedata_vs_stateflow)
        val viewModel = ViewModelProvider(this)[LifeCycleAwareCompViewModel::class.java]

        val textView: TextView = findViewById(R.id.textViewLivedata)
        val textViewStateFlow: TextView = findViewById(R.id.textViewStateFlow)
        val stringBuilder = StringBuilder()
        // Apply custom style if needed


        viewModel.startTimer()
        viewModel.timerLiveData.observe(this@LiveDataVsStateFlowActivity) {
            Log.d("here", stringBuilder.toString())
            textView.text = textView.text.toString() + it.toString()
        }
        lifecycleScope.launch{
            viewModel.timerStateFlow.collect {
                Log.d("here", stringBuilder.toString())
                textViewStateFlow.text = textViewStateFlow.text.toString() + it.toString()
            }
        }
    }

}