package com.example.library2.mvvm.model

import com.example.library2.mvvm.data.OperationCallback

interface MuseumDataSource{
    fun retrieveMuseums(callback: OperationCallback<Museum>)
    fun cancel()
}