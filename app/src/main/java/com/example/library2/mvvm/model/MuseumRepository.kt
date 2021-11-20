package com.example.library2.mvvm.model

import com.example.library2.mvvm.data.ApiClient
import com.example.library2.mvvm.data.OperationResult
import java.lang.Exception
import javax.inject.Inject


class MuseumRepository @Inject constructor():MuseumDataSource {
    override suspend fun retrieveMuseums(): OperationResult<Museum> {
        try {
            val response = ApiClient.build()?.museums()
            response?.let {
                return if (it.isSuccessful && it.body()!=null){
                    val data= it.body()?.data
                    OperationResult.Success(data)
                }else{
                    val message = it.body()?.msg
                    OperationResult.Error(Exception(message))
                }
            }?: run {return OperationResult.Error(Exception("Error happened"))}
        }catch (e:Exception){
            return OperationResult.Error(e)
        }
    }

}