package com.example.library2.emedinaa.cleanarchi.data

import com.example.library2.emedinaa.cleanarchi.domain.Museum

interface MuseumDataSource {
    suspend fun retrieveMuseums(): OperationResult<Museum>
}
