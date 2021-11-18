package com.example.library2.mvvm.di

import com.example.library2.mvvm.model.MuseumRepository
import com.example.library2.mvvm.viewmodel.ViewModelFactory

object Injection {
    private var museumViewModelFactory :ViewModelFactory?=null
    private var museumRepository: MuseumRepository? = null


  /*  private fun createMuseumDataSource(): MuseumDataSource {
        val dataSource = MuseumRemoteDataSource(ApiClient)
        museumDataSource = dataSource
        return dataSource
    }*/

    private fun createMuseumRepository(): MuseumRepository {
        val repository = MuseumRepository(/*provideDataSource()*/)
        museumRepository = repository
        return repository
    }

    private fun createFactory(): ViewModelFactory {
        val factory = ViewModelFactory(providerRepository())
        museumViewModelFactory = factory
        return factory
    }

    private fun providerRepository() = museumRepository ?: createMuseumRepository()

    fun provideViewModelFactory() = museumViewModelFactory?:createFactory()

    fun destroy() {
//        museumDataSource = null
        museumRepository = null
        museumViewModelFactory = null
    }
}