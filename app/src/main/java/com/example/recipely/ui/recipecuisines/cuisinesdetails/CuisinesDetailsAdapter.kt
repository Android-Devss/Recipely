package com.example.recipely.ui.recipecuisines.cuisinesdetails

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.recipely.data.source.model.Recipe
import com.example.recipely.databinding.ItemCuisinesBinding
import com.example.recipely.databinding.ItemCuisinesDetailsBinding
import com.example.recipely.databinding.ItemPopularRecipeBinding
import com.example.recipely.ui.base.BaseAdapter
import com.example.recipely.util.loadImageWithPlaceholderAndCrossFade

class CuisinesDetailsAdapter(private val recipes: List<Recipe>):BaseAdapter<Recipe,ItemCuisinesDetailsBinding>(recipes) {
    override val bindingInflater : (LayoutInflater, ViewGroup?, Boolean) -> ItemCuisinesDetailsBinding
        get() = ItemCuisinesDetailsBinding::inflate

    override fun onBindViewHolder(
        holder : BaseViewHolder<ItemCuisinesDetailsBinding>,
        position : Int,
        currentItem : Recipe
    ) {
        holder.binding.apply {
            cuisineDetailsCuisineName.text=currentItem.cuisine
            cuisineDetailsRecipeName.text=currentItem.recipeName
            cuisineDetailsRecipeImage.loadImageWithPlaceholderAndCrossFade(currentItem.imageUrl)
        }
    }

}