package com.example.library2.mvvm.model1.model

import com.example.library2.mvvm.model1.data.OperationResult

interface MuseumDataSource{
    suspend fun retrieveMuseums(): OperationResult<Museum>

}