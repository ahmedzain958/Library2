package com.example.library2.mvvm.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.library2.mvvm.data.OperationCallback
import com.example.library2.mvvm.model.Museum
import com.example.library2.mvvm.model.MuseumRepository

class MuseumViewModel(private val repository: MuseumRepository) : ViewModel() {

    private val _museums = MutableLiveData<List<Museum>>().apply { value = emptyList() }
    val museums: LiveData<List<Museum>> = _museums

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    private val _isEmptyList = MutableLiveData<Boolean>()
    val isEmptyList: LiveData<Boolean> = _isEmptyList

    private val _onMessageError = MutableLiveData<Any>()
    val onMessageError: LiveData<Any> = _onMessageError

    fun loadMuseums() {
        _isLoading.value = true
        repository.fetchMuseums(object : OperationCallback<Museum> {
            override fun onSuccess(data: List<Museum>?) {
                _isLoading.value = false
                if (data.isNullOrEmpty())
                    _isEmptyList.value = false
                else
                    _museums.value = data
            }

            override fun onError(error: String?) {
                _isLoading.value = false
                _onMessageError.value = error
            }

        })
    }
}