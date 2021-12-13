package com.example.library2.mvvm2.data

import com.example.library2.mvvm2.message.OperationResult
import com.example.library2.mvvm2.model.Museum
import com.example.library2.mvvm2.model.MuseumRepository

class MuseumRemoteDataSource : MuseumRepository {

    override suspend fun retrieveMuseums(): OperationResult<Museum> {
        try {
            val response = ApiClient.build()?.museums()
            response?.let {
                return if (it.isSuccessful && it.body() != null) {
                    val data = it.body()?.data
                    OperationResult.Success(data)
                } else {
                    val message = it.body()?.msg
                    OperationResult.Error(Exception(message))
                }
            } ?: run {
                return OperationResult.Error(Exception("Ocurrió un error"))
            }
        } catch (e: Exception) {
            return OperationResult.Error(e)
        }
    }

}