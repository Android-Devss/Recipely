package com.example.recipely.util

import android.view.View
import android.widget.ImageView
import androidx.fragment.app.Fragment
import coil.load
import com.example.recipely.R
import com.google.android.material.bottomnavigation.BottomNavigationView

fun ImageView.loadImageWithPlaceholderAndCrossFade(url: String) {
    this.load(url) {
        crossfade(1000)
        placeholder(R.drawable.recipe_image_placeholder)
        error(R.drawable.recipe_image_error)
    }
}

fun Int.toTimeFormat() = "$this min"

fun Fragment.replaceFragment(fragment: Fragment) {

    requireActivity().supportFragmentManager.beginTransaction()
        .replace(R.id.fragment_container, fragment).addToBackStack(null)
        .commit()
    requireActivity().findViewById<BottomNavigationView>(R.id.bottom_navigation_bar).visibility=View.VISIBLE
}

fun Fragment.addFragment(fragment: Fragment) {
    requireActivity().supportFragmentManager.beginTransaction()
        .add(R.id.fragment_container, fragment).addToBackStack(null)
        .commit()
}

fun Int.toCountFormat() = "$this Items"

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