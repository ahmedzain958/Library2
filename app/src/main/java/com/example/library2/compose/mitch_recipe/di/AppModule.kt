package com.example.library2.compose.mitch_recipe.di

import android.content.Context
import com.example.library2.ApplicationClass
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Because the Android operating system instantiates many of its own framework classes, using Dagger in an Android app requires you to write a substantial amount of boilerplate. Hilt reduces the boilerplate code that is involved in using Dagger in an Android application. Hilt automatically generates and provides the following:
 *
 * Components for integrating Android framework classes with Dagger that you would otherwise need to create by hand.
 * Scope annotations to use with the components that Hilt generates automatically.
 * Predefined bindings to represent Android classes such as Application or Activity.
 * Predefined qualifiers to represent @ApplicationContext and @ActivityContext.
 */
@Module
@InstallIn(SingletonComponent::class/*/* For hilt versions lower than v2.28.2 use ApplicationComponent instead of
SingletonComponent. ApplicationComponent is deprecated and even removed in
some versions above v2.28.2 so better refactor it to SingletonComponent. */*/)
/**
 * Our dependencies will exist as long as our application is alive
 */
object AppModule {
    /**
     * In Dagger Hilt, @ApplicationContext is used to specify that the injected parameter should be provided with the application context.
     * Here's how you can use @ApplicationContext in Dagger Hilt in Kotlin
     *
     * class MyRepository @Inject constructor(@ApplicationContext private val context: Context) {
     *     // Use the application context here
     * }
     */
    @Singleton
    @Provides
    fun provideApplication(@ApplicationContext app: Context
    /*By annotating context with @ApplicationContext provided by Hilt, we don't need to create a provider for the application context.*/
    ): ApplicationClass {
        return app as ApplicationClass
    }
}