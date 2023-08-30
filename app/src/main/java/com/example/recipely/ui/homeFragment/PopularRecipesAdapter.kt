package com.example.recipely.ui.homeFragment

import android.view.LayoutInflater
import android.view.ViewGroup
import coil.load
import com.example.recipely.data.source.model.Recipe
import com.example.recipely.databinding.HomePopularCardBinding

class PopularRecipesAdapter (recipes: List<Recipe>)
    : HomeBaseAdapter<Recipe, HomePopularCardBinding>(recipes) {
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> HomePopularCardBinding
        get() = HomePopularCardBinding::inflate
    override fun onBindViewHolder(
        holder: BaseViewHolder<HomePopularCardBinding>,position: Int
        ,currentItem:Recipe

    ) {
        holder.binding.apply {
            recipeName.text = currentItem.recipeName
            recipeImage.load(currentItem.imageUrl)
        }
    }
}
