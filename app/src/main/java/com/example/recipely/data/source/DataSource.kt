package com.example.recipely.data.source

import com.example.recipely.data.repository.Recipe
import com.example.recipely.data.source.util.CsvParser

interface DataSource {
    fun getAllRecipes() : List<Recipe>

}


