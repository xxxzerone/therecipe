package eu.tutorials.myrecipe2

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://www.themealdb.com/api/json/v1/1/"

private val retrofit = Retrofit.Builder()
    .baseUrl(BASE_URL)
    .addConverterFactory(GsonConverterFactory.create())
    .build()

interface RecipeApi {
    @GET("categories.php")
    suspend fun getCategories(): CategoriesResponse
}

val recipeApiService = retrofit.create(RecipeApi::class.java)
