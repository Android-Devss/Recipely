package com.example.recipely.data.repository

import com.example.recipely.data.source.DataSource
import com.example.recipely.data.source.model.Recipe
import com.example.recipely.domain.Repository

class RepositoryImp(private val dataSource: DataSource) : Repository {
    private val recipeList = dataSource.getAllRecipes()

    override fun getAllRecipes(): List<Recipe> {
        return dataSource.getAllRecipes()
    }

    override fun searchAboutRecipes(searchQuery: String): List<Recipe> {
        return recipeList.filter {
            it.cuisine.lowercase().startsWith(searchQuery.lowercase()) || it.recipeName.lowercase()
                .startsWith(searchQuery.lowercase())
        }
    }
}