package com.example.recipely.domain.usecase

import com.example.recipely.data.source.model.Recipe
import com.example.recipely.domain.Repository

class GetRecipeByName(private val repository: Repository) {
    operator fun invoke(recipeName: String): Recipe {

        return repository.getAllRecipes()
            .first { it.recipeName == recipeName }
    }
}