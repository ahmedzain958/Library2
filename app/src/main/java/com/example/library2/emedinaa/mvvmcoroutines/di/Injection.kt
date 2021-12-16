package com.example.library2.emedinaa.mvvmcoroutines.di

import com.emedinaa.kotlinmvvm.data.ApiClient
import com.example.library2.emedinaa.mvvmcoroutines.data.MuseumDataSource
import com.example.library2.emedinaa.mvvmcoroutines.data.MuseumRemoteDataSource
import com.example.library2.emedinaa.mvvmcoroutines.model.MuseumRepository

/**
 * @author Eduardo Medina
 */
object Injection {
    private var museumDataSource: MuseumDataSource? = null
    private var museumRepository: MuseumRepository? = null

    private fun createMuseumDataSource(): MuseumDataSource {
        val dataSource = MuseumRemoteDataSource(ApiClient)
        museumDataSource = dataSource
        return dataSource
    }

    private fun createMuseumRepository(): MuseumRepository {
        val repository = MuseumRepository(provideDataSource())
        museumRepository = repository
        return repository
    }

    private fun provideDataSource() = museumDataSource ?: createMuseumDataSource()

    fun providerRepository() = museumRepository ?: createMuseumRepository()

    fun destroy() {
        museumDataSource = null
        museumRepository = null
    }
}