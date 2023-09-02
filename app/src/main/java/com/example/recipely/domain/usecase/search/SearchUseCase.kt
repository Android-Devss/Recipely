package com.example.recipely.domain.usecase.search

import com.example.recipely.data.source.model.Recipe
import com.example.recipely.domain.Repository

class SearchUseCase(private val repository: Repository) {
    operator fun invoke(searchQuery: SearchQuery, limit: Int = 25): List<Recipe>? {
        return with(searchQuery) {
            repository
                .getRecipes()
                .filterByName(name)
                ?.shuffled()
                ?.take(limit)
        }
    }
}

private fun Recipe.doesMatchRecipeName(recipeName: String): Boolean {
    return recipeName.startsWith(recipeName, ignoreCase = true)
}
private fun List<Recipe>.filterByName(recipeName: String): List<Recipe>? {
    return filter { it.doesMatchRecipeName(recipeName) }
        .takeIf { it.isNotEmpty() }
}
