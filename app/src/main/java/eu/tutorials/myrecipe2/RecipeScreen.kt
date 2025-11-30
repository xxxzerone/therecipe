package eu.tutorials.myrecipe2

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import coil.compose.rememberAsyncImagePainter

@Composable
fun RecipeScreen(modifier: Modifier = Modifier, viewState: RecipeState, navigateToDetailScreen: (Category) -> Unit) {
    Box(modifier = modifier.fillMaxSize()) {
        when {
            viewState.loading -> CircularProgressIndicator(Modifier.align(Alignment.Center))
            viewState.error != null -> Text("ERROR OCCURRED")
            else -> CategoryScreen(viewState.data, navigateToDetailScreen)
        }
    }
}

@Composable
fun CategoryScreen(categories: List<Category>, navigateToDetailScreen: (Category) -> Unit) {
    LazyVerticalGrid(columns = GridCells.Fixed(2)) {
        items(categories) { category ->
            CategoryItem(category, navigateToDetailScreen)
        }
    }
}

@Composable
fun CategoryItem(category: Category, navigateToDetailScreen: (Category) -> Unit) {
    Column(
        modifier = Modifier.clickable { navigateToDetailScreen(category) },
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = rememberAsyncImagePainter(category.strCategoryThumb),
            contentDescription = null,
            modifier = Modifier.aspectRatio(1f)
        )

        Text(text = category.strCategory, color = Color.Black, fontWeight = FontWeight.Bold)
    }
}