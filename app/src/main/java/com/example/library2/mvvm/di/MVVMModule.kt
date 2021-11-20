package com.example.library2.mvvm.di

import com.example.library2.mvvm.model.MuseumDataSource
import com.example.library2.mvvm.model.MuseumRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

/**
 * @author : Eduardo Medina
 */
@Module
@InstallIn(ApplicationComponent::class)
object MVVMModule {

    @Singleton
    @Provides
    fun providerRepository(): MuseumDataSource {
        return MuseumRepository()
    }
}