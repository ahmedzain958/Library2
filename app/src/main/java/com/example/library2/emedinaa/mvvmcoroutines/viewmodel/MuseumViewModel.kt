package com.example.library2.emedinaa.mvvmcoroutines.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.library2.emedinaa.mvvmcoroutines.data.OperationResult
import com.example.library2.emedinaa.mvvmcoroutines.model.Museum
import com.example.library2.emedinaa.mvvmcoroutines.model.MuseumRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

/**
 * @author Eduardo Medina
 */
class MuseumViewModel(private val repository: MuseumRepository) : ViewModel() {

    private val _museums = MutableLiveData<List<Museum>>().apply { value = emptyList() }
    val museums: LiveData<List<Museum>> = _museums

    private val _isViewLoading = MutableLiveData<Boolean>()
    val isViewLoading: LiveData<Boolean> = _isViewLoading

    private val _onMessageError = MutableLiveData<Any>()
    val onMessageError: LiveData<Any> = _onMessageError

    private val _isEmptyList = MutableLiveData<Boolean>()
    val isEmptyList: LiveData<Boolean> = _isEmptyList

    /*
    If you require that the data be loaded only once, you can consider calling the method
    "loadMuseums()" on constructor. Also, if you rotate the screen, the service will not be called.
     */

    fun loadMuseums() {
        _isViewLoading.value = true
        viewModelScope.launch {
            var result: OperationResult<Museum> = withContext(Dispatchers.IO) {//executes @ first
                repository.fetchMuseums()
            }
            _isViewLoading.value = false
            when (result) {
                is OperationResult.Success -> {
                    if (result.data.isNullOrEmpty()) {
                        _isEmptyList.value = true
                    } else {
                        _museums.value = result.data
                    }
                }
                is OperationResult.Error -> {
                    _onMessageError.value = result.exception?:Exception("Ocurrió un error")
                }
            }
        }
    }
}