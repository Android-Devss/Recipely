package com.example.recipely.domain.usecase.cuisine

import com.example.recipely.data.source.model.Recipe
import com.example.recipely.domain.Repository

class GetCuisineRecipesUseCase(private val repository: Repository) {
    operator fun invoke(cuisine: String): List<Recipe> {

        return repository.getAllRecipes()
            .filter { it.cuisine == cuisine }
    }
}