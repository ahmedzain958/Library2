package com.example.library2.emedinaa.mvvmcallbacks.model

import com.emedinaa.kotlinmvvm.data.OperationCallback
import com.example.library2.emedinaa.mvvmcallbacks.model.Museum

/**
 * @author Eduardo Medina
 */
interface MuseumDataSource {

    fun retrieveMuseums(callback: OperationCallback<Museum>)
    fun cancel()
}