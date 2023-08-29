package com.example.recipely.data.source

import android.content.Context
import com.example.recipely.data.source.model.Recipe
import com.example.recipely.util.Constant.FileName.CSV_FILE_NAME
import com.example.recipely.util.CsvParser
import java.io.BufferedReader
import java.io.InputStreamReader

class GetCsvDataSource(private val context: Context, private val parser: CsvParser) :

    GetRecipesDataSource {
    override fun getAllRecipes(): List<Recipe> {
        val recipeList = mutableListOf<Recipe>()
        context.apply {
            val inputStream = assets.open(CSV_FILE_NAME)
            val buffer = BufferedReader(InputStreamReader(inputStream))
            buffer.forEachLine {
                val currentRecipe = parser.parseLine(it)
                recipeList.add(currentRecipe)
            }
        }
        return recipeList
    }
}