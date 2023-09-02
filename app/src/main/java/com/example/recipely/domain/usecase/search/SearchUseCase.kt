package com.example.recipely.domain.usecase.search

import com.example.recipely.data.source.model.Recipe
import com.example.recipely.domain.Repository

class SearchUseCase(private val repository: Repository) {

    fun searchAboutRecipes(searchQuery: String): List<Recipe> {
        return repository.getAllRecipes()
            .filter {
            it.cuisine.lowercase().startsWith(searchQuery.lowercase()) ||
                    it.recipeName.lowercase().startsWith(searchQuery.lowercase())
        }
    }
}
