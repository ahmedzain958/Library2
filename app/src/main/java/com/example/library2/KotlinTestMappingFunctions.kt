package com.example.library2

import com.example.library2.compose.mitch_recipe.network.model.RecipeDTO
import com.example.library2.compose.mitch_recipe.network.model.RecipeDTOMapper

class KotlinTestMappingFunctions {
    fun testMapping() {
        val recipe = RecipeDTOMapper().mapToDomainModel(RecipeDTO())
        val entity = RecipeDTOMapper().mapFromDomainModel(recipe)
    }
}