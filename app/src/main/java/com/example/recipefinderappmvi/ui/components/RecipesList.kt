package com.example.recipefinderappmvi.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.recipefinderappmvi.data.model.Meal

/**
 * Created by AidenChang 2023/10/26
 */

@Composable
fun RecipesList(recipes: List<Meal>) {
    LazyColumn(
        modifier = Modifier.fillMaxSize().background(Color.White)
    ) {
        item(recipes) {
            RecipeListItem(it)
        }
    }
}