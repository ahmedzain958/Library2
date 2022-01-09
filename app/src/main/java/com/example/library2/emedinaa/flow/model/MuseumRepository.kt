package com.example.library2.emedinaa.flow.model

import com.example.library2.emedinaa.flow.data.ApiClient
import com.example.library2.emedinaa.flow.exception.EmptyListException
import com.example.library2.emedinaa.flow.exception.ServiceException
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*

/**
 * @author : Eduardo Medina
 */
class MuseumRepository : MuseumDataSource {

    override fun retrieveMuseumsFlow(): Flow<List<Museum>> {
        return flow {
            emit(ApiClient.build()?.museums())
        }.flowOn(Dispatchers.IO)
            .map {
                val list = it?.body()?.data
                if (it?.isSuccessful == true) {
                    if (list.isNullOrEmpty()) throw EmptyListException()
                    else list
                } else {
                    throw ServiceException(it?.body()?.msg)
                }
            }
            .catch { e ->
                Exception(e)
            }
    }

}