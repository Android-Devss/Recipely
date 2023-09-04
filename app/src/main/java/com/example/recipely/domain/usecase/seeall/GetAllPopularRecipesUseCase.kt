package com.example.recipely.domain.usecase.seeall

import com.example.recipely.data.source.model.Recipe
import com.example.recipely.domain.Repository

class GetAllPopularRecipesUseCase(private val repository: Repository) {

    operator fun invoke(items: Int): List<Recipe> {
        return repository.getAllRecipes()
            .filter { it.ingredientsCount in (5..11) }
            .sortedBy { it.totalTimeInMinutes }
            .take(items)
    }
}