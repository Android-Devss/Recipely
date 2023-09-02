package com.example.recipely.domain

import com.example.recipely.data.source.model.Advice
import com.example.recipely.data.source.model.Recipe

interface Repository {
    fun getRecipes(): List<Recipe>
    fun searchAboutRecipes(searchQuery: String): List<Recipe>
    fun getRecipe(id: Int): Recipe
}