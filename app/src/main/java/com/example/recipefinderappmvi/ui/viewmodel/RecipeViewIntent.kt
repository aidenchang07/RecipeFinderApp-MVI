package com.example.recipefinderappmvi.ui.viewmodel

/**
 * Created by AidenChang 2023/10/25
 */
sealed class RecipeViewIntent {
    object LoadRandomRecipe : RecipeViewIntent()
    data class SearchRecipe(val query: String) : RecipeViewIntent()
}
