package com.example.library2.viewbindingemedina

import com.example.library2.mvvm2.message.OperationResult
import com.example.library2.mvvm2.model.Museum
import com.example.library2.mvvm2.model.MuseumRepository


/**
 * @author Eduardo Medina
 */
class FakeEmptyMuseumRepository : MuseumRepository {

    override suspend fun retrieveMuseums(): OperationResult<Museum> {
        return OperationResult.Success(emptyList())
    }
}