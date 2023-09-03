package com.example.recipely.ui.recipecuisines

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.recipely.data.source.model.Recipe
import com.example.recipely.databinding.ItemCuisinesBinding
import com.example.recipely.ui.base.BaseAdapter
import com.example.recipely.ui.recipehome.HomeAdapter
import com.example.recipely.util.loadImageWithPlaceholderAndCrossFade

class CuisinesAdapter(private val recipes: List<Recipe>,private val listener: CuisinesAdapter.CuisinesInteractionListener):BaseAdapter<Recipe,ItemCuisinesBinding>(recipes) {
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
            root.setOnClickListener{
                listener.onClickCuisine(currentItem.recipeName)
            }
        }
    }
    interface CuisinesInteractionListener : BaseAdapter.BaseInteractionListener {
        fun onClickCuisine(recipeName: String)
    }


}