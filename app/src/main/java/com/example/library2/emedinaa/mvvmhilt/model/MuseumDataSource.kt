package com.example.library2.emedinaa.mvvmhilt.model

import com.example.library2.emedinaa.mvvmhilt.data.OperationResult

interface MuseumDataSource{
    suspend fun retrieveMuseums(): OperationResult<Museum>

}