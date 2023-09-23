package com.example.library2.compose.mitch_recipe.respository

import com.example.library2.compose.mitch_recipe.domain.model.Recipe
import com.example.library2.compose.mitch_recipe.network.RecipeService
import com.example.library2.compose.mitch_recipe.network.model.RecipeDTOMapper

class RecipeRepositoryImpl(
    private val recipeService: RecipeService,
    private val recipeDTOMapper: RecipeDTOMapper,
) : RecipeRepository {
    override suspend fun search(token: String, page: Int, query: String): List<Recipe> {
        return recipeDTOMapper.toDomainList(recipeService.search(token, page, query).recipes)
    }

    override suspend fun get(token: String, id: Int): Recipe {
        return recipeDTOMapper.mapToDomainModel(recipeService.get(token, id))
    }
}