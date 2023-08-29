package com.example.recipely.domain

import com.example.recipely.data.source.model.Recipe


object DataManager {

    private val recipeList = mutableListOf<Recipe>()
    val recipes : List<Recipe>
        get() = recipeList.toList()
    private var recipeIndex = 1


    fun addRecipe(match : Recipe) {
        recipeList.add(match)
    }

    fun deleteRecipe(index : Int) {
        recipeList.removeAt(index)
    }

    fun getCurrentRecipe() : Recipe = recipeList[recipeIndex]
    fun getNextRecipe() : Recipe {
        recipeIndex++
        if (recipeIndex == recipeList.size) {
            recipeIndex = 0
        }
        return recipeList[recipeIndex]
    }

    fun getPreviousRecipe() : Recipe {
        recipeIndex--
        if (recipeIndex == -1) {
            recipeIndex = recipeList.size - 1
        }
        return recipeList[recipeIndex]
    }


}