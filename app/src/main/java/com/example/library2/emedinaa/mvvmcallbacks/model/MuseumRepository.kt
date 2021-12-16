package com.example.library2.emedinaa.mvvmcallbacks.model

import com.emedinaa.kotlinmvvm.data.OperationCallback
import com.example.library2.emedinaa.mvvmcallbacks.model.Museum
import com.example.library2.emedinaa.mvvmcallbacks.model.MuseumDataSource

/**
 * @author Eduardo Medina
 */
class MuseumRepository(private val museumDataSource: MuseumDataSource) {

    fun fetchMuseums(callback: OperationCallback<Museum>) {
        museumDataSource.retrieveMuseums(callback)
    }

    fun cancel() {
        museumDataSource.cancel()
    }
}