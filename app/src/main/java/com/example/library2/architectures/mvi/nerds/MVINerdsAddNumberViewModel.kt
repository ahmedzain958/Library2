package com.example.library2.architectures.mvi.nerds

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.consumeAsFlow
import kotlinx.coroutines.launch
import java.lang.Exception

class MVINerdsAddNumberViewModel : ViewModel() {
    /**
     * An unlimited channel in Kotlin has no predefined buffer size and allows producers to send elements to the channel without any limit on its size.
     * This means it can hold an unlimited number of elements. The send() operation on an unlimited channel does not block and will always succeed
     */
    val intentChannel = Channel<MainIntent>(capacity = Channel.UNLIMITED)

    private val _viewStateFlow = MutableStateFlow<MainViewState>(MainViewState.Idle)
    val stateFlow get() = _viewStateFlow

    var number = 0

    init {
        processMainIntent()
    }

    fun processMainIntent() {
        viewModelScope.launch {
            intentChannel.consumeAsFlow().collect {
                when (it) {
                    MainIntent.AddNumber -> addNumber()
                }
            }
        }
    }

    //reducing the resukt
    fun addNumber() {
        /*viewModelScope.launch {

        }*/
        _viewStateFlow.value = try {
            MainViewState.AddNumber(number = number + 5)
        } catch (e: Exception) {
            MainViewState.Error(e.message!!)

        }
    }
}