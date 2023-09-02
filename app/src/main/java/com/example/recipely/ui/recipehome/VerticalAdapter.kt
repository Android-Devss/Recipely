package com.example.recipely.ui.recipehome

import android.view.LayoutInflater
import android.view.ViewGroup
import coil.load
import com.example.recipely.R
import com.example.recipely.data.source.model.Recipe
import com.example.recipely.databinding.ItemEasyToCookRecipeBinding
import com.example.recipely.ui.base.BaseAdapter

class VerticalAdapter(items: List<Recipe>,private val listener : OnHomeClickListener) :
    BaseAdapter<Recipe, ItemEasyToCookRecipeBinding>(items) {
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> ItemEasyToCookRecipeBinding
        get() = ItemEasyToCookRecipeBinding::inflate

    override fun onBindViewHolder(
        holder: BaseViewHolder<ItemEasyToCookRecipeBinding>,
        position: Int,
        currentItem: Recipe
    ) {
        holder.binding.apply {
            verticalRecipeCuisine.text = currentItem.cuisine
            verticalRecipeName.text = currentItem.recipeName
            verticalRecipeImage.load(currentItem.imageUrl) {
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