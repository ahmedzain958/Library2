package com.example.library2.mvvm.model

import com.example.library2.mvvm.data.OperationResult

interface MuseumDataSource{
    suspend fun retrieveMuseums(): OperationResult<Museum>

}