package com.example.recipely.domain.usecase.search

import com.example.recipely.data.source.model.Recipe
import com.example.recipely.domain.Repository

class SearchUseCase(var repository: Repository) {

    operator fun invoke(searchQuery: String): List<Recipe> {
        return repository.getAllRecipes()
            .filter { it.recipeName.lowercase().startsWith(searchQuery.lowercase()) }
    }
}
