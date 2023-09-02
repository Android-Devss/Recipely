package com.example.recipely.data.repository

import com.example.recipely.data.source.DataSource
import com.example.recipely.data.source.model.Recipe
import com.example.recipely.domain.Repository

class RepositoryImp(private val dataSource: DataSource) : Repository {
    private val recipeList = dataSource.getAllRecipes()
    override fun getRecipes(): List<Recipe> {
        return dataSource.getAllRecipes()
    }

    override fun getRecipe(id: Int) = recipeList[id]
    override fun searchAboutRecipes(searchQuery: String): List<Recipe> {
        return recipeList.filter {
            it.recipeName.lowercase().startsWith(searchQuery.lowercase())
        }
    }
}



