package com.example.library2.views.viewpager

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class UserInputViewModel:ViewModel() {
    // MutableLiveData to store user inputs
    private val _userInputLiveData = MutableLiveData<String>()
    val userInputLiveData: LiveData<String> = _userInputLiveData

    fun setUserInput(input: String) {
        _userInputLiveData.value = input
    }
}