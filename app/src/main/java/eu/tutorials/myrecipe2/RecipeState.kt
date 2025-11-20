package eu.tutorials.myrecipe2

data class RecipeState(
    val data: List<Category> = emptyList(),
    val loading: Boolean = true,
    val error: String? = null
)
