package com.example.recipely.data.source

import com.example.recipely.data.source.model.Advice
import com.example.recipely.data.source.model.Recipe

interface DataSource {

    fun getAllRecipes() : List<Recipe>
    fun getAdvices(): List<Advice>

}


