package com.example.recipefinderappmvi.ui.viewmodel

import com.example.recipefinderappmvi.data.model.Meal

/**
 * Created by AidenChang 2023/10/25
 */
sealed class RecipeViewState {
    object Loading: RecipeViewState()
    data class Success(val recipes: List<Meal>): RecipeViewState()
    data class Error(val message: String): RecipeViewState()
}
