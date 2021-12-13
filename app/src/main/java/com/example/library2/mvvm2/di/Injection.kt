package com.example.library2.mvvm2.di

import com.example.library2.mvvm2.data.MuseumRemoteDataSource
import com.example.library2.mvvm2.model.MuseumRepository

/**
 * @author Eduardo Medina
 */
object Injection {

    private var museumRepository: MuseumRepository? = null

    private fun createMuseumRepository(): MuseumRepository {
        val repository = MuseumRemoteDataSource()
        museumRepository = repository
        return repository
    }

    fun providerRepository(): MuseumRepository = museumRepository ?: createMuseumRepository()

    fun destroy() {
        museumRepository = null
    }
}