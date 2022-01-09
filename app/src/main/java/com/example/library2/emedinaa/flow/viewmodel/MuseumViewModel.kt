package com.example.library2.emedinaa.flow.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.library2.emedinaa.flow.exception.EmptyListException
import com.example.library2.emedinaa.flow.exception.ServiceException
import com.example.library2.emedinaa.flow.model.Museum
import com.example.library2.emedinaa.flow.model.MuseumDataSource
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onStart

/**
 * @author : Eduardo Medina
 */
class MuseumViewModel(private val repository: MuseumDataSource) : ViewModel() {

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
    fun loadMuseumsFlow(): LiveData<List<Museum>> {
        return repository.retrieveMuseumsFlow()
            .onStart {
                _isViewLoading.postValue(true)
            }.catch {
                when (it) {
                    is EmptyListException -> _isEmptyList.postValue(true)
                    is ServiceException -> _onMessageError.postValue(it)
                    else -> _onMessageError.postValue(it)
                }
            }.onCompletion {
                _isViewLoading.postValue(false)
            }.asLiveData()
    }
}