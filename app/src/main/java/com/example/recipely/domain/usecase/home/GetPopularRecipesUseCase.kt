package com.example.recipely.domain.usecase.home

import com.example.recipely.data.source.model.Recipe
import com.example.recipely.domain.Repository

class GetPopularRecipesUseCase(private val repository: Repository) {

    operator fun invoke(): List<Recipe> {
        return repository.getAllRecipes()
            .filter { it.ingredientsCount > 4 }
            .sortedBy { it.totalTimeInMinutes }
    }
}