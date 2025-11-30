package eu.tutorials.myrecipe2

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun RecipeApp(navController: NavHostController, modifier: Modifier = Modifier) {
    val viewModel: MainViewModel = viewModel()
    val viewState by viewModel.categoriesState

    NavHost(navController = navController, startDestination = Screen.RecipeScreen.route) {
        composable(route = Screen.RecipeScreen.route) {
            RecipeScreen(modifier = modifier, viewState = viewState) {
                navController.currentBackStackEntry?.savedStateHandle?.set("category", it)
                navController.navigate(Screen.CategoryDetailScreen.route)
            }
        }
        composable(route = Screen.CategoryDetailScreen.route) {
            val category =
                navController.previousBackStackEntry?.savedStateHandle?.get("category") ?: Category("", "", "", "")
            CategoryDetailScreen(modifier = modifier, category = category)
        }
    }
}