package com.example.library2.mvvm.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.library2.mvvm.model.Museum
import com.example.library2.mvvm.model.MuseumRepository

class MuseumViewModel(private val repository: MuseumRepository): ViewModel() {
    private val _museums = MutableLiveData<List<Museum>>().apply { value = emptyList()  }
    val museums :LiveData<List<Museum>> = _museums


}