package com.example.recipely.ui.homeFragment

import android.view.LayoutInflater
import android.view.ViewGroup
import coil.load
import com.example.recipely.data.source.model.Recipe
import com.example.recipely.databinding.ItemHomePopularCardBinding
import com.example.recipely.ui.base.BaseAdapter

class PopularRecipesAdapter (recipes: List<Recipe>)
    : BaseAdapter<Recipe, ItemHomePopularCardBinding>(recipes) {
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> ItemHomePopularCardBinding
        get() = ItemHomePopularCardBinding::inflate
    override fun onBindViewHolder(
        holder: BaseViewHolder<ItemHomePopularCardBinding>,position: Int
        ,currentItem:Recipe

    ) {
        holder.binding.apply {
            recipeName.text = currentItem.recipeName
            recipeImage.load(currentItem.imageUrl)
        }
    }
}
