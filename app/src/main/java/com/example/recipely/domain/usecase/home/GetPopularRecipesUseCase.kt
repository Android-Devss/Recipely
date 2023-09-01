package com.example.recipely.domain.usecase.home

import com.example.recipely.data.source.model.Recipe
import com.example.recipely.domain.Repository

class GetPopularRecipesUseCase(private val repository: Repository) {

    operator fun invoke(items: Int): List<Recipe> {
        return repository.getAllRecipes()
            .filter { it.ingredientsCount < 10 }
            .sortedBy { it.totalTimeInMinutes }
            .shuffled()
            .take(items)
    }
}