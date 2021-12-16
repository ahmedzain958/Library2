package com.example.library2.emedinaa.mvvmcoroutines.model

import com.example.library2.emedinaa.mvvmcoroutines.data.MuseumDataSource
import com.example.library2.emedinaa.mvvmcoroutines.data.OperationResult

class MuseumRepository (private val dataSource: MuseumDataSource){
    suspend fun fetchMuseums():OperationResult<Museum> = dataSource.retrieveMuseums()
}