package com.example.recipely.data.repository

import com.example.recipely.data.source.DataSource
import com.example.recipely.data.source.model.Recipe
import com.example.recipely.domain.Repository

class RepositoryImp(private val dataSource : DataSource) : Repository {
    private val recipeList = dataSource.getAllRecipes()
    override fun getAllRecipes() : List<Recipe> {
      return  recipeList
    }

}