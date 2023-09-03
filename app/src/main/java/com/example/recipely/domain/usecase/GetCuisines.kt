package com.example.recipely.domain.usecase

import com.example.recipely.domain.Repository

class GetCuisines(val repository: Repository) {
    operator fun invoke() : List<String> {
        return getAllCuisines()

    }
    private fun getAllCuisines(): List<String> {
        return repository.getAllRecipes()
            .map { it.cuisine }.distinct()
            .shuffled()
    }
}