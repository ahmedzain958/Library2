package com.example.library2.challenge2convertthreadstocoroutinesviewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.random.Random

class CoroutinesViewModel : ViewModel() {
    val dicePair = MutableLiveData<Pair<Int, Int>>()

    fun rollDice(indices: IntRange) {
        for (imageIndex in indices) {
            viewModelScope.launch {
                for (i in 1..20) {
                    dicePair.value = Pair(imageIndex, getDieValue())
                    delay(100L)
                }
            }
        }
    }

    /**
     * Get a random number from 1 to 6
     */
    private fun getDieValue(): Int {
        return Random.nextInt(1, 7)
    }
}

