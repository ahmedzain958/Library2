package com.example.library2.emedinaa.mvvmroom.di

import android.content.Context
import com.example.library2.emedinaa.mvvmroom.data.db.DBDataSource
import com.example.library2.emedinaa.mvvmroom.data.remote.MuseumRemoteDataSourceInterface
import com.example.library2.emedinaa.mvvmroom.model.MuseumDbDataSource
import com.example.library2.emedinaa.mvvmroom.model.MuseumRemoteDataSource
import com.example.library2.emedinaa.mvvmroom.model.MuseumRepository

object Injection {
    private lateinit var dbDataSource : DBDataSource
    private lateinit var  museumRemoteDataSource : MuseumRemoteDataSourceInterface
    fun setup(context: Context){
        dbDataSource = MuseumDbDataSource(context)
        museumRemoteDataSource = MuseumRemoteDataSource()
    }
    fun providerRepository(): MuseumRepository {
        return MuseumRepository(dbDataSource, museumRemoteDataSource)
    }
}