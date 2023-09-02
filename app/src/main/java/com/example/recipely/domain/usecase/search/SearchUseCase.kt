package com.example.recipely.domain.usecase.search

import com.example.recipely.data.source.DataSource
import com.example.recipely.data.source.model.Recipe

class SearchUseCase(dataSource: DataSource) {
    private val recipeList = dataSource.getAllRecipes()

    fun searchAboutRecipes(searchQuery: String): List<Recipe> {
        return recipeList.filter {
            it.cuisine.lowercase().startsWith(searchQuery.lowercase()) || it.recipeName.lowercase()
                .startsWith(searchQuery.lowercase())
        }
    }

}
