package com.example.recipely.domain.usecase.home

import com.example.recipely.data.source.model.Recipe
import com.example.recipely.domain.Repository

class GetEasyRecipesUseCase(private val repository: Repository) {

    operator fun invoke(items: Int): List<Recipe> {
        return repository.getAllRecipes()
            .filter { it.totalTimeInMinutes < 30 }
            .sortedBy { it.ingredientsCount }
            .shuffled()
            .take(items)
    }
}