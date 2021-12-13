package com.example.library2.mvvm2.model

import com.example.library2.mvvm2.message.OperationResult

interface MuseumRepository {
    suspend fun retrieveMuseums(): OperationResult<Museum>
}