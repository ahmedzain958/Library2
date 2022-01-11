package com.example.library2.emedinaa.cleanarchi.data

import androidx.hilt.lifecycle.ViewModelInject
import com.example.library2.emedinaa.cleanarchi.domain.Museum
import javax.inject.Inject

/**
 * @author Eduardo Medina
 */
class MuseumRepository @Inject constructor(private val dataSource: MuseumDataSource) {

    suspend fun fetchMuseums(): OperationResult<Museum> = dataSource.retrieveMuseums()
}