package com.example.recipely.domain.usecase

import com.example.recipely.data.source.model.Recipe
import com.example.recipely.domain.Repository

class GetRecipeById(private val repository: Repository) {
    operator fun invoke(id: Int): Recipe {

        return repository.getAllRecipes()
            .first { it.id == id }
    }
}