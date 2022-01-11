package com.example.library2.emedinaa.cleanarchi.di

import com.example.library2.emedinaa.cleanarchi.data.MuseumDataSource
import com.example.library2.emedinaa.cleanarchi.data.MuseumRepository
import com.example.library2.emedinaa.cleanarchi.data.remote.ApiClient
import com.example.library2.emedinaa.cleanarchi.data.remote.MuseumRemoteDataSource
import com.example.library2.emedinaa.cleanarchi.domain.GetMuseumsUseCase
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
    fun providerApiClient(): ApiClient.ServicesApiInterface? {
        return ApiClient.build()
    }

    @Singleton
    @Provides
    fun providerDataSource(apiClient: ApiClient.ServicesApiInterface?): MuseumDataSource {
        return MuseumRemoteDataSource(apiClient)
    }

    @Singleton
    @Provides
    fun providerRepository(museumDataSource: MuseumDataSource): MuseumRepository {
        return MuseumRepository(museumDataSource)
    }
 @Singleton
    @Provides
    fun providerGetMuseumsUseCase(museumRepository: MuseumRepository): GetMuseumsUseCase {
        return GetMuseumsUseCase(museumRepository)
    }

}