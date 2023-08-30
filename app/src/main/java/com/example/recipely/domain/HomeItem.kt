package com.example.recipely.domain


data class HomeItem<T>(
    val item: T,
    val type: Int
)