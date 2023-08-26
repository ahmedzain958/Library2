package com.example.library2.coroutines_flows.nerds

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class LifeCycleAwareCompViewModel: ViewModel() {
    private val _timerLiveData = MutableLiveData<Int>()
    public val timerLiveData: MutableLiveData<Int> = _timerLiveData

    private val _timerStateFlow = MutableStateFlow<Int>(0)
    public val timerStateFlow: MutableStateFlow<Int> = _timerStateFlow

    public fun startTimer(){
        viewModelScope.launch {
            launch {
                val list = listOf<Int>(0,1,1,1,2,2,3,4,5,6)
                for (i in list){
                    _timerLiveData.value = i
                    delay(500)
                }
            }
            launch {
                val stateFlowListNotRepeated = mutableListOf<Int>(0,1,2,3,4,4,5,5)
                for (i in stateFlowListNotRepeated){
                    _timerStateFlow.emit(i)
                    delay(500)
                }
            }



        }
    }
}