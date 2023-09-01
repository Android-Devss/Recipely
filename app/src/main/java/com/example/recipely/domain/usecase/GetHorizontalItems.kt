package com.example.recipely.domain.usecase

import com.example.recipely.data.source.model.Recipe
import com.example.recipely.domain.Repository

class GetHorizontalItems (private val repository: Repository){
    operator fun invoke(items: Int):List<Recipe> {
        return repository.getAllRecipes().take(items)
    }
}