package com.example.recipely.domain.usecase

import com.example.recipely.data.source.model.Recipe
import com.example.recipely.domain.Repository

class GetVerticaItems (private val repository: Repository){
    operator fun invoke():List<Recipe> {
        return repository.getAllRecipes()
    }
}