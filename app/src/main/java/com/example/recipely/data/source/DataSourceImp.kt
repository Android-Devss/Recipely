package com.example.recipely.data.source

import android.content.Context
import com.example.recipely.data.source.model.Recipe

class DataSourceImp(private val context : Context, private val csvParser : GetCsvDataSource) : DataSource {

    private val recipeList = csvParser.getAllRecipes()
    override fun getAllRecipes(): List<Recipe> {
      return csvParser.getAllRecipes()
    }

    override fun getPopularRecipes(): List<Recipe> {
        return recipeList.filter {
            it.ingredientsCount < 4
        }.sortedBy {
            it.totalTimeInMinutes
        }    }

    override fun getEasyRecipes(): List<Recipe> {
        return recipeList.filter {
            it.totalTimeInMinutes < 30
        }.sortedBy { it.ingredientsCount }
    }

}