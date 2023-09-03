package com.example.recipely.domain.usecase.cuisine

import com.example.recipely.data.repository.RepositoryImp
import com.example.recipely.data.source.model.Recipe


class GetCuisinesUseCase(var repository: RepositoryImp) {
    operator fun invoke(): List<Recipe> {
        return repository.getAllCuisines()
            .sortedBy { it.cuisine.first() }
    }
}