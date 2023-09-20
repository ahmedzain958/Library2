package com.example.library2

import com.example.library2.compose.mitch_recipe.domain.util.EntityMapper
import com.example.library2.compose.mitch_recipe.network.model.RecipeNetworkEntity
import com.example.library2.compose.mitch_recipe.network.model.RecipeNetworkMapper

class KotlinTestMappingFunctions {
    fun testMapping() {
        val recipe = RecipeNetworkMapper().mapFromEntity(RecipeNetworkEntity())
        val entity = RecipeNetworkMapper().mapToEntity(recipe)
    }
}