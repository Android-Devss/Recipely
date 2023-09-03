package com.example.recipely.ui.seeAllHome

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.recipely.data.source.model.Recipe
import com.example.recipely.databinding.ItemSeeAllCardBinding
import com.example.recipely.ui.base.BaseAdapter
import com.example.recipely.util.loadImageWithPlaceholderAndCrossFade

class SeeAllAdapter(recipes: List<Recipe>, private val listener: RecipeInteractionListener) :
    BaseAdapter<Recipe, ItemSeeAllCardBinding>(recipes) {
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> ItemSeeAllCardBinding
        get() = ItemSeeAllCardBinding::inflate

    override fun onBindViewHolder(
        holder: BaseViewHolder<ItemSeeAllCardBinding>,
        position: Int,
        currentItem: Recipe
    ) {
        holder.binding.apply {
            Name.text = currentItem.recipeName
            recipeImage.loadImageWithPlaceholderAndCrossFade(currentItem.imageUrl)
            root.setOnClickListener { listener.onClickRecipeName(currentItem.recipeName) }
        }
    }

    interface RecipeInteractionListener : BaseInteractionListener {
        fun onClickRecipeName(recipeName: String)
    }
}