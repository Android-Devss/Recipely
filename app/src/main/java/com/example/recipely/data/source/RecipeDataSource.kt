package com.example.recipely.data.source

import com.example.recipely.data.source.model.Recipe

interface RecipeDataSource {
    fun getAllRecipes(): List<Recipe>
}