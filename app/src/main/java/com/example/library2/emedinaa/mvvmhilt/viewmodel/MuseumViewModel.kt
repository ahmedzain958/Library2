package com.example.library2.emedinaa.mvvmhilt.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.library2.emedinaa.mvvmhilt.data.OperationResult
import com.example.library2.emedinaa.mvvmhilt.model.Museum
import com.example.library2.emedinaa.mvvmhilt.model.MuseumRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MuseumViewModel @ViewModelInject constructor (private val repository: MuseumRepository) : ViewModel() {

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
        viewModelScope.launch {
            var  result: OperationResult<Museum> = withContext(Dispatchers.IO){
                repository.retrieveMuseums()
            }
            _isLoading.postValue(false)
            when(result){
                is OperationResult.Success ->{
                    if(result.data.isNullOrEmpty()){
                        _isEmptyList.postValue(true)
                    }else{
                        _museums.value = result.data
                    }
                }
                is OperationResult.Error ->{
                    _onMessageError.postValue(result.exception)
                }
            }
        }
    }
}