package com.example.recipely.ui.recipehome

import android.view.LayoutInflater
import android.view.ViewGroup
import coil.load
import com.example.recipely.R
import com.example.recipely.data.source.model.Recipe
import com.example.recipely.databinding.HorizontalCardHomeBinding
import com.example.recipely.ui.base.BaseAdapter

class HorizontalAdapter ( private var items: List<Recipe>):BaseAdapter<Recipe, HorizontalCardHomeBinding>(items){
    override val bindingInflater : (LayoutInflater, ViewGroup?, Boolean) -> HorizontalCardHomeBinding
        get() = HorizontalCardHomeBinding::inflate

    override fun onBindViewHolder(
        holder : BaseViewHolder<HorizontalCardHomeBinding>,
        position : Int,
        currentItem : Recipe
    ) {
        val currentItem = items[position]

        holder.binding.apply {
            horizontalRecipeNameHome.text=currentItem.recipeName
            horizontalRecipeImageHome.load(currentItem.imageUrl) {
                crossfade(true)
                placeholder(R.drawable.recipe_image_placeholder)
                error(R.drawable.recipe_image_error)
        }
        }
    }
}