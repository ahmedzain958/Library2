package com.example.library2.mvvm.model

import com.example.library2.mvvm.data.OperationCallback

class MuseumRepository(private val museumDataSource: MuseumDataSource) {
    fun fetchMuseums(callback: OperationCallback<Museum>){
        museumDataSource.retrieveMuseums(callback)
    }
}