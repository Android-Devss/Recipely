package com.example.recipely.util

import android.widget.ImageView
import androidx.fragment.app.Fragment
import coil.load
import com.example.recipely.R

fun Int.toCountFormat() = "$this Items"

fun Int.toTimeFormat() = "$this min"


fun ImageView.loadImageWithPlaceholderAndCrossFade(url: String) {
    this.load(url) {
        crossfade(1000)
        placeholder(R.drawable.recipe_image_placeholder)
        error(R.drawable.recipe_image_error)
    }
}

fun Fragment.replaceFragment(fragment: Fragment) {
    val fragmentManager = requireActivity().supportFragmentManager
    val fragmentTransaction = fragmentManager.beginTransaction()
    fragmentTransaction.replace(R.id.fragment_container, fragment).addToBackStack(null)
    fragmentTransaction.commit()
}
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