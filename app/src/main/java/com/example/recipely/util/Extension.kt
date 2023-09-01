package com.example.recipely.util

import com.example.recipely.data.source.model.Recipe

fun Int.toCountFormat() = "$this Items"

fun Int.toTimeFormat() = "$this min"

fun String.toIngredientsFormat(): String {
    val ingredients = this.split(";")
    val formattedIngredients = ingredients.mapIndexed { index, ingredient ->
        if (index == -1) {
            ingredient.trim()
        } else {
            "• ${ingredient.trim()}"
        }
    }
    return formattedIngredients.joinToString("\n")
}
fun String.toInstructionsFormat() = this.replace(";", "\n✓ ")