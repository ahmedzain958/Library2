package com.example.library2.compose.mitch_recipe.di

import com.example.library2.compose.mitch_recipe.network.RecipeService
import com.example.library2.compose.mitch_recipe.network.model.RecipeDTOMapper
import com.example.library2.compose.mitch_recipe.respository.RecipeRepository
import com.example.library2.compose.mitch_recipe.respository.RecipeRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Singleton
    @Provides
    fun provideRecipeRepository(
        recipeService: RecipeService,
        recipeDTOMapper: RecipeDTOMapper,
    ): RecipeRepository {
        return RecipeRepositoryImpl(recipeService, recipeDTOMapper)
    }

}