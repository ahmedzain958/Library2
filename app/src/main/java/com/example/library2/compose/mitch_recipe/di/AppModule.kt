package com.example.library2.compose.mitch_recipe.di

import android.content.Context
import com.example.library2.ApplicationClass
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
/**
 * Our dependencies will exist as long as our application is alive
 */
object AppModule {
    @Singleton
    fun provideApplication(/*@ApplicationContext */app: Context): ApplicationClass {
        return app as ApplicationClass
    }
}