package com.example.library2.lifecycleawarecomp

import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableStringBuilder
import android.text.style.StyleSpan
import android.util.Log
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.library2.R
import kotlinx.coroutines.launch

class LifeCycleAwareCompActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_life_cycle_aware_comp)
        val viewModel = ViewModelProvider(this)[LifeCycleAwareCompViewModel::class.java]

        val textView: TextView = findViewById(R.id.textViewLivedata)
        val textViewStateFlow: TextView = findViewById(R.id.textViewStateFlow)
        val stringBuilder = StringBuilder("Live Data")
        // Apply custom style if needed


        viewModel.startTimer()
        viewModel.timerLiveData.observe(this@LifeCycleAwareCompActivity) {
            Log.d("zain", stringBuilder.toString())
            textView.text = textView.text.toString() + it.toString()
        }
        lifecycleScope.launch{
            viewModel.timerStateFlow.collect {
                Log.d("zain", stringBuilder.toString())
                textViewStateFlow.text = textViewStateFlow.text.toString() + it.toString()
            }
        }
    }

}