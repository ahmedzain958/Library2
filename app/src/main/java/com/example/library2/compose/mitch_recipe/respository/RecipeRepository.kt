package com.example.library2.compose.mitch_recipe.respository

import com.example.library2.compose.mitch_recipe.domain.model.Recipe

interface RecipeRepository {
    /*
        UI should only know about domain models, shouldn't know about DTOs (network related)/ entities
     */
    suspend fun search(token: String, page: Int, query: String):List<Recipe>
    suspend fun get(token: String, id: Int):Recipe

}