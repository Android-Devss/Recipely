package com.example.recipely.domain

import com.example.recipely.data.source.model.Recipe

interface Repository {

    fun getAllRecipes(): List<Recipe>
}