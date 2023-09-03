package com.example.recipely.ui.fragment.search

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.recipely.data.source.model.Recipe
import com.example.recipely.databinding.ItemSearchCardBinding
import com.example.recipely.ui.base.BaseAdapter
import com.example.recipely.util.loadImageWithPlaceholderAndCrossFade

class SearchAdapter(private var recipes: List<Recipe>, private val onClickAction: ActionListener) :
    BaseAdapter<Recipe, ItemSearchCardBinding>(recipes) {
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> ItemSearchCardBinding
        get() = ItemSearchCardBinding::inflate

    override fun onBindViewHolder(
        holder: BaseViewHolder<ItemSearchCardBinding>,
        position: Int,
        currentItem: Recipe
    ) {
        holder.binding.apply {
            tvRecipeName.text = currentItem.recipeName
            tvRecipeCuisine.text = currentItem.cuisine
            ivRecipeImage.loadImageWithPlaceholderAndCrossFade(currentItem.imageUrl)
            root.setOnClickListener { onClickAction.onRecipeClick(currentItem.recipeName) }
        }
    }

    override fun setItems(newItems: List<Recipe>) {
        recipes = newItems
        super.setItems(newItems)
    }
}