package com.example.library2.emedinaa.mvvmroom.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.example.library2.emedinaa.mvvmroom.data.OperationResult
import com.example.library2.emedinaa.mvvmroom.data.db.DBDataSource
import com.example.library2.emedinaa.mvvmroom.data.db.MuseumDTo
import com.example.library2.emedinaa.mvvmroom.data.remote.MuseumRemoteDataSourceInterface


class MuseumRepository(
    private val dbDataSource: DBDataSource,
    private val remoteDataSourceInterface: MuseumRemoteDataSourceInterface
) {
    suspend fun retrieveMuseums(): OperationResult<Museum> {
        return remoteDataSourceInterface.retrieveMuseums()
    }

    fun getMuseums(): LiveData<List<Museum>> {
        val museumsFromDbDataSourceLiveData: LiveData<List<MuseumDTo>> = dbDataSource.museums()
        //converts from LiveData<List<MuseumDTO>> to LiveData<List<Museum>>
        return Transformations.map(museumsFromDbDataSourceLiveData) {
            it.map { itItem -> Museum(itItem.id, itItem.name, itItem.photo) }//here is List<Museum>
        }
        /* //converts from LiveData<List<MuseumDTO>> to LiveData<List<Museum>>
     return Transformations.switchMap(museumsFromDbDataSourceLiveData) {
         MutableLiveData<List<Museum>>()//here is MutableLiveData<List<Museum>>
     }*/
    }

    suspend fun sync(museumList: List<Museum>) {
        dbDataSource.deleteMuseums()
        dbDataSource.addMuseums(museumList.map {
            MuseumDTo(it.id, it.name, it.photo)
        })
    }
}
