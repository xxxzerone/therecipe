package eu.tutorials.myrecipe2

sealed class Screen(val route: String) {
    object RecipeScreen : Screen("recipescreen")
    object CategoryDetailScreen : Screen("categorydetailscreen")
}