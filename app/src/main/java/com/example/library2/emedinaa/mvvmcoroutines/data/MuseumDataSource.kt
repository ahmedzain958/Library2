package com.example.library2.emedinaa.mvvmcoroutines.data

import com.example.library2.emedinaa.mvvmcoroutines.model.Museum

/**
 * @author Eduardo Medina
 */
interface MuseumDataSource {
    suspend fun retrieveMuseums():OperationResult<Museum>
}