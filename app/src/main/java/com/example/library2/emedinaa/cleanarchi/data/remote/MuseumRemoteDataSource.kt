package com.example.library2.emedinaa.cleanarchi.data.remote

import androidx.hilt.lifecycle.ViewModelInject
import com.example.library2.emedinaa.cleanarchi.data.MuseumDataSource
import com.example.library2.emedinaa.cleanarchi.data.OperationResult
import com.example.library2.emedinaa.cleanarchi.domain.Museum
import javax.inject.Inject

/**
 * @author Eduardo Medina
 */
class MuseumRemoteDataSource @Inject constructor(private val service : ApiClient.ServicesApiInterface?) :
    MuseumDataSource {


    override suspend fun retrieveMuseums(): OperationResult<Museum> {
        try {
            val response = service?.museums()
            response?.let {
                return if (it.isSuccessful && it.body() != null) {
                    val data = it.body()?.data
                    OperationResult.Success(data)
                } else {
                    val message = it.body()?.msg
                    OperationResult.Error(
                        Exception(
                            message
                        )
                    )
                }
            } ?: run {
                return OperationResult.Error(
                    Exception("Ocurrió un error")
                )
            }
        } catch (e: Exception) {
            return OperationResult.Error(e)
        }
    }
}