package com.example.recipely.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.recipely.data.source.model.Recipe
import com.example.recipely.databinding.ItemPopularRecipeBinding
import com.example.recipely.ui.base.BaseAdapter
import com.example.recipely.util.loadImageWithPlaceholderAndCrossFade

class HorizontalAdapter(
    items: List<Recipe>,
    private val listener: HomeAdapter.HomeInteractionListener
) :
    BaseAdapter<Recipe, ItemPopularRecipeBinding>(items) {
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> ItemPopularRecipeBinding
        get() = ItemPopularRecipeBinding::inflate

    override fun onBindViewHolder(
        holder: BaseViewHolder<ItemPopularRecipeBinding>,
        position: Int,
        currentItem: Recipe
    ) {
        holder.binding.apply {
            horizontalRecipeNameHome.text = currentItem.recipeName
            horizontalRecipeCuisineHome.text = currentItem.cuisine
            horizontalRecipeImageHome.loadImageWithPlaceholderAndCrossFade(currentItem.imageUrl)
            horizontalRecipeCardHome.setOnClickListener {
                listener.onClickRecipe(currentItem.recipeName)
            }
        }
    }
}