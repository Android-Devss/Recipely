package com.example.recipely.ui.recipehome

import android.view.LayoutInflater
import android.view.ViewGroup
import coil.load
import com.example.recipely.R
import com.example.recipely.data.source.model.Recipe
import com.example.recipely.databinding.ItemPopularRecipeBinding
import com.example.recipely.ui.base.BaseAdapter

class HorizontalAdapter(items: List<Recipe>,private val listener:OnHomeClickListener) :
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
            horizontalRecipeImageHome.load(currentItem.imageUrl) {
                crossfade(true)
                crossfade(500)
                placeholder(R.drawable.recipe_image_placeholder)
                error(R.drawable.recipe_image_error)
            }
            root.setOnClickListener {
                listener.onRecipeClicked(currentItem.id)
            }
        }
    }
}