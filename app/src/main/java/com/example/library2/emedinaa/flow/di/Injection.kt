package com.example.library2.emedinaa.flow.di

import com.example.library2.emedinaa.flow.model.MuseumDataSource
import com.example.library2.emedinaa.flow.model.MuseumRepository


/**
 * @author : Eduardo Medina
 */
object Injection {
    private val museumRepository = MuseumRepository()
    fun providerRepository(): MuseumDataSource = museumRepository
}