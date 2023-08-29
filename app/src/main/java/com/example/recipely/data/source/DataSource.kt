package com.example.recipely.data.source

import com.example.recipely.data.source.model.Recipe

interface DataSource {
    fun getAllRecipes() : List<Recipe>
    fun getPopularRecipes(): List<Recipe>
    fun getEasyRecipes(): List<Recipe>

}


