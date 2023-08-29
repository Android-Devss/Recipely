package com.example.recipely.data.source

import android.content.Context
import android.util.Log
import com.example.recipely.data.source.model.Recipe
import com.example.recipely.util.Constant.FileName.CSV_FILE_NAME
import com.example.recipely.util.CsvParser
import java.io.BufferedReader
import java.io.InputStreamReader

class DataSourceImp(private val context : Context, private val csvParser : CsvParser) : DataSource {

    val recipeList = (mutableListOf<Recipe>())
    override fun getAllRecipes() : List<Recipe> {

        context.apply {
            val inputStream = assets.open(CSV_FILE_NAME)
            val buffer = BufferedReader(InputStreamReader(inputStream))
            buffer.forEachLine {
                val currentRecipe = csvParser.parseLine(it)
                recipeList.add(currentRecipe)
                Log.v("Main_Activity", it)
            }
        }
        return recipeList
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