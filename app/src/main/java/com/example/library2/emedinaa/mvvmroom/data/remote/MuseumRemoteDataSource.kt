package com.example.library2.emedinaa.mvvmroom.data.remote

import com.example.library2.emedinaa.mvvmroom.data.OperationResult
import com.example.library2.emedinaa.mvvmroom.model.Museum

interface MuseumRemoteDataSource {
    suspend fun retrieveMuseums(): OperationResult<Museum>
}