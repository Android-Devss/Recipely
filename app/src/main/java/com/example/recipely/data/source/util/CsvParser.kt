package com.example.recipely.data.source.util

import com.example.recipely.data.repository.Recipe

class CsvParser {

    fun parseLine(line : String) : Recipe {
        val tokens = line.split(",")
        return Recipe(
            recipeName = tokens[Constant.ColumnIndex.RECIPE_NAME],
            ingredients = tokens[Constant.ColumnIndex.INGREDIENTS],
            totalTimeInMinutes = tokens[Constant.ColumnIndex.TOTAL_TIME].toInt(),
            cuisine = tokens[Constant.ColumnIndex.CUISINE],
            instructions = tokens[Constant.ColumnIndex.INSTRUCTIONS],
            url = tokens[Constant.ColumnIndex.URL],
            cleanedIngredients = tokens[Constant.ColumnIndex.CLEANED_INGREDIENTS],
            imageUrl = tokens[Constant.ColumnIndex.IMAGE_URL],
            ingredientsCount = tokens[Constant.ColumnIndex.INGREDIENTS_COUNT].toInt(),
        )
    }

}