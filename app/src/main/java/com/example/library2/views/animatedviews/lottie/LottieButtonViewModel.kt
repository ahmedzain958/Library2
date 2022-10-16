package com.example.library2.views.animatedviews.lottie

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LottieButtonViewModel : ViewModel() {

    private val _isFavButtonActive = MutableLiveData(false)
    val isFavButtonActive: LiveData<Boolean> = _isFavButtonActive

    fun setAnimationInactive() {
        _isFavButtonActive.value = false
    }
}