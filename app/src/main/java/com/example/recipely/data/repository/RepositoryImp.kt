package com.example.recipely.data.repository

import com.example.recipely.data.source.DataSource
import com.example.recipely.data.source.model.Recipe
import com.example.recipely.domain.Repository

class RepositoryImp(private val dataSource: DataSource) : Repository {

    override fun getAllRecipes(): List<Recipe> {
        return dataSource.getAllRecipes()
    }
}