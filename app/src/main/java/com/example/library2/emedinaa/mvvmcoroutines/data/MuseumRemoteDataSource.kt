package com.example.library2.emedinaa.mvvmcoroutines.data

import com.emedinaa.kotlinmvvm.data.ApiClient
import com.example.library2.emedinaa.mvvmcoroutines.model.Museum

/**
 * @author Eduardo Medina
 */
class MuseumRemoteDataSource(apiClient: ApiClient) : MuseumDataSource {
    private val service: ApiClient.ServicesApiInterface? = apiClient.build()
    override suspend fun retrieveMuseums(): OperationResult<Museum> {
        try {
            val response = service?.museums()
            response?.let {
                return if (it.isSuccessful && it.body() != null) {
                    val data: List<Museum>? = it.body()?.data
                    OperationResult.Success(data)
                } else {
                    val message = it.body()?.msg
                    OperationResult.Error(Exception(message))
                }
            }
        } catch (e: Exception) {
            return OperationResult.Error(e)
        }
        return OperationResult.Error(Exception("failed"))
    }


}