package com.example.recipefinderappmvi.ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import com.example.recipefinderappmvi.ui.components.LoadingComponent
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
            SuccessComponent(recipes = recipes) {
                recipeViewModel.processIntent(RecipeViewIntent.SearchRecipe(it))
            }
        }
        is RecipeViewState.Error -> {
            val message = (state as RecipeViewState.Error).message
            ErrorComponent(message = message) {
                recipeViewModel.processIntent(RecipeViewIntent.LoadRandomRecipe)
            }
        }
    }
}