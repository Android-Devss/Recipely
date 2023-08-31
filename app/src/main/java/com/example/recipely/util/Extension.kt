package com.example.recipely.util

fun Int.toCountFormat() = "$this Items"

fun Int.toTimeFormat() = "$this min"

fun String.toIngredientsFormat() = this.replace(";", "\n• ")

fun String.toInstructionsFormat() = this.replace(";", "\n✓ ")