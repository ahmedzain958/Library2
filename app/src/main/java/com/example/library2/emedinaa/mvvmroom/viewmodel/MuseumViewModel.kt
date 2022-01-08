package com.example.library2.emedinaa.mvvmroom.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.library2.emedinaa.mvvmroom.data.OperationResult
import com.example.library2.emedinaa.mvvmroom.model.Museum
import com.example.library2.emedinaa.mvvmroom.model.MuseumRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

/**
 * Two way to communication between viewmodel and repository is

Using callback interface
Using Transformations.
Transformations has map and switchMap operators similar to RxJava which can converts on livedata to different one

You can also use Mediator livedata to create your own custom operators. MediatorLiveData is used for observing multiple livedata sources and perform on there changes.
 */
class MuseumViewModel(private val museumRepository: MuseumRepository):ViewModel() {
    private val _isViewLoading= MutableLiveData<Boolean>()
    val isViewLoading: LiveData<Boolean> = _isViewLoading

    val museums = museumRepository.getMuseums()

    fun retrieveMuseums(){
        _isViewLoading.postValue(true)
        viewModelScope.launch {
            var  result: OperationResult<Museum> = withContext(Dispatchers.IO){
                museumRepository.retrieveMuseums()
            }
            _isViewLoading.postValue(false)
            if(result is OperationResult.Success){
                withContext((Dispatchers.IO)) {
                    result.data?.let {
                        if (it.isNotEmpty()) museumRepository.sync(it)
                    }
                }
            }
        }
    }

    fun cancel(){
        viewModelScope.cancel()
    }
}