package com.example.recipely.ui.recipehome

import android.view.LayoutInflater
import android.view.ViewGroup
import coil.load
import com.example.recipely.R
import com.example.recipely.data.source.model.Recipe
import com.example.recipely.databinding.ItemEasyToCookRecipeBinding
import com.example.recipely.ui.base.BaseAdapter
import com.example.recipely.util.loadImageWithPlaceholderAndCrossFade

class VerticalAdapter(items: List<Recipe>,val listener : HorizontalAdapter.HomeInteractionListener) :
    BaseAdapter<Recipe, ItemEasyToCookRecipeBinding>(items) {
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> ItemEasyToCookRecipeBinding
        get() = ItemEasyToCookRecipeBinding::inflate

    override fun onBindViewHolder(
        holder: BaseViewHolder<ItemEasyToCookRecipeBinding>,
        position: Int,
        currentItem: Recipe
    ) {
        holder.binding.apply {
            verticalRecipeImage.loadImageWithPlaceholderAndCrossFade(currentItem.imageUrl)
            verticalRecipeCuisine.text = currentItem.cuisine
            verticalRecipeName.text = currentItem.recipeName
            listener.onClickRecipe(currentItem.id)

        }
    }
}