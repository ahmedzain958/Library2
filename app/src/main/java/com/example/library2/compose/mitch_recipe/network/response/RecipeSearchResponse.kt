package com.example.library2.compose.mitch_recipe.network.response

import com.example.library2.compose.mitch_recipe.network.model.RecipeDTO
import com.google.gson.annotations.SerializedName

data class RecipeSearchResponse(

    @SerializedName("count")
    var count: Int,

    @SerializedName("results")
    var recipes: List<RecipeDTO>,
)
