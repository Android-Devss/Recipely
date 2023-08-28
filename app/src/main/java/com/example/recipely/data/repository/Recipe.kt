package com.example.recipely.data.repository

import android.os.Parcelable

data class Recipe(
    val recipeName : String,
    val ingredients : String,
    val totalTimeInMinutes : Int,
    val cuisine : String,
    val instructions : String,
    val url : String,
    val cleanedIngredients : String,
    val imageUrl : String,
    val ingredientsCount : Int
)
