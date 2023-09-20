package com.example.library2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.compose.material3.Text
import androidx.compose.ui.platform.ComposeView
import com.example.library2.compose.mitch_recipe.network.RecipeService
import com.google.gson.GsonBuilder
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class TestCallingRetrofitActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test_calling_retrofit)
        val service = Retrofit.Builder()
            .baseUrl("https://food2fork.ca/api/recipe/")
            .addConverterFactory(
                GsonConverterFactory.create(
                    GsonBuilder().create()
                )
            ).build()
            .create(RecipeService::class.java)
        CoroutineScope(IO).launch {
            val recipe = service
                .get(token = "Token 9c8b06d329136da358c2d00e76946b0111ce2c48", 583)
            findViewById<ComposeView>(R.id.compose).setContent {
                Text(text = recipe.title.toString())
            }
        }


    }
}