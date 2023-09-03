package com.example.recipely.domain.usecase.home

import com.example.recipely.data.repository.RepositoryImp
import com.example.recipely.data.source.model.Recipe

class GetCuisinesRecipeUseCase(var repository : RepositoryImp) {
    operator fun invoke(cuisineName: String) : List<Recipe> {
        return repository.getAllRecipes()
            .filter {
                it.cuisine == cuisineName
            }
    }
}

