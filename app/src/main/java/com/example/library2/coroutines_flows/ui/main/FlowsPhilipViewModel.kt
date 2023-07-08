package com.example.library2.coroutines_flows.ui.main

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch

class FlowsPhilipViewModel : ViewModel() {

    val countDownFlow = flow<Int> {
        val startingValue = 10
        var currentValue = startingValue
        emit(startingValue)
        while (currentValue > 0) {
            delay(1000)
            currentValue--
            emit(currentValue)
        }
    }

    /*init {
        viewModelScope.launch {
            countDownFlow.collectLatest {
                delay(1500)
                Log.d("FlowsPhilipFragment", "timer = $it")
            }
        }
    }
*/
}