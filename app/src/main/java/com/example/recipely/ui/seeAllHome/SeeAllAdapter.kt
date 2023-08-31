package com.example.recipely.ui.seeAllHome

import android.view.LayoutInflater
import android.view.ViewGroup
import coil.load
import com.example.recipely.data.source.model.Recipe
import com.example.recipely.databinding.AllPopularCardHomeBinding
import com.example.recipely.ui.homeFragment.HomeBaseAdapter

class SeeAllAdapter (recipes: List<Recipe>)
    : HomeBaseAdapter<Recipe, AllPopularCardHomeBinding>(recipes) {
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> AllPopularCardHomeBinding
        get() = AllPopularCardHomeBinding::inflate

    override fun onBindViewHolder(
        holder: BaseViewHolder<AllPopularCardHomeBinding>, position: Int, currentItem: Recipe

    ) {
        holder.binding.apply {
            Name.text = currentItem.recipeName
            recipeImage.load(currentItem.imageUrl)
        }
    }

    interface RecipeInteractionListener : HomeBaseAdapter.BaseInteractionListener {
        fun onClickRecipe(recipeId: Int)
    }
}