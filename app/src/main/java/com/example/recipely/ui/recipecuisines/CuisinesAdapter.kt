package com.example.recipely.ui.recipecuisines

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.recipely.data.source.model.Recipe
import com.example.recipely.databinding.FragmentRecipeCuisinesBinding
import com.example.recipely.databinding.ItemCuisinesBinding
import com.example.recipely.ui.base.BaseAdapter
import com.example.recipely.util.loadImageWithPlaceholderAndCrossFade

class CuisinesAdapter(private val recipes: List<Recipe>):BaseAdapter<Recipe,ItemCuisinesBinding>(recipes) {
    override val bindingInflater : (LayoutInflater, ViewGroup?, Boolean) -> ItemCuisinesBinding
        get() = ItemCuisinesBinding::inflate

    override fun onBindViewHolder(
        holder: BaseViewHolder<ItemCuisinesBinding>,
        position: Int,
        currentItem: Recipe
    ) {
        holder.binding.apply {
            cuisineImage.loadImageWithPlaceholderAndCrossFade(currentItem.imageUrl)
            cuisineName.text = currentItem.cuisine
//            root.visibility = if (isUniqueCuisineName(currentItem.cuisine)) View.VISIBLE else View.GONE
        }
    }

    private fun isUniqueCuisineName(cuisineName: String): Boolean {
        val count = recipes.count { it.cuisine == cuisineName }
        return count == 1
    }
}