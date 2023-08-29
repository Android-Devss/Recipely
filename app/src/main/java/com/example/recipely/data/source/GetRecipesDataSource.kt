package com.example.recipely.data.source

import com.example.recipely.data.source.model.Recipe

interface GetRecipesDataSource {
    fun getAllRecipes(): List<Recipe>
}