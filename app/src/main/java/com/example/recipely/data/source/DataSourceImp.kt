package com.example.recipely.data.source

import android.content.Context
import com.example.recipely.data.source.model.Recipe
import com.example.recipely.util.Constant.FileName.CSV_FILE_NAME
import com.example.recipely.util.CsvParser
import java.io.BufferedReader
import java.io.InputStreamReader

class DataSourceImp(private val context: Context, private val csvParser: CsvParser) : DataSource {
    private val tag = this::class.java.simpleName
    private var id = 0

    override fun getAllRecipes(): List<Recipe> {
        val recipeList = mutableListOf<Recipe>()

        context.apply {
            val inputStream = assets.open(CSV_FILE_NAME)
            val buffer = BufferedReader(InputStreamReader(inputStream))
            buffer.forEachLine {
                val currentRecipe = csvParser.parseLine(it, id++)
                recipeList.add(currentRecipe)
            }
        }
        return recipeList
    }
}