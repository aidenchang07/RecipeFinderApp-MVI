package com.example.recipefinderappmvi.ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import com.example.recipefinderappmvi.ui.components.ErrorComponent
import com.example.recipefinderappmvi.ui.components.LoadingComponent
import com.example.recipefinderappmvi.ui.components.SuccessComponent
import com.example.recipefinderappmvi.ui.viewmodel.RecipeViewIntent
import com.example.recipefinderappmvi.ui.viewmodel.RecipeViewModel
import com.example.recipefinderappmvi.ui.viewmodel.RecipeViewState

/**
 * Created by AidenChang 2023/10/25
 */

@Composable
fun HomeScreen(recipeViewModel: RecipeViewModel) {
    val state by recipeViewModel.state

    when(state) {
        RecipeViewState.Loading -> LoadingComponent()
        is RecipeViewState.Success -> {
            val recipes = (state as RecipeViewState.Success).recipes
            SuccessComponent(recipes = recipes, onSearchClicked = { query ->
                recipeViewModel.processIntent(RecipeViewIntent.SearchRecipe(query))
            })
        }
        is RecipeViewState.Error -> {
            val message = (state as RecipeViewState.Error).message
            ErrorComponent(message = message, onRefreshClicked = {
                recipeViewModel.processIntent(RecipeViewIntent.LoadRandomRecipe)
            })
        }
    }

    LaunchedEffect(Unit) {
        recipeViewModel.processIntent(RecipeViewIntent.LoadRandomRecipe)
    }
}