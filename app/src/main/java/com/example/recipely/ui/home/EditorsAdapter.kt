package com.example.recipely.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import coil.load
import com.example.recipely.R
import com.example.recipely.data.source.model.Recipe
import com.example.recipely.databinding.HomeEditorsCardBinding
import com.example.recipely.ui.base.BaseAdapter

class EditorsAdapter(
    editorsRecipeList: List<Recipe>,
) : BaseAdapter<Recipe, HomeEditorsCardBinding>(editorsRecipeList) {


    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> HomeEditorsCardBinding
        get() = HomeEditorsCardBinding::inflate

    override fun onBindViewHolder(
        holder: BaseViewHolder<HomeEditorsCardBinding>,
        position: Int,
        currentItem: Recipe
    ) {
        holder.binding.apply {
            recipeName1.text = currentItem.recipeName
            recipeImage1.load(currentItem.imageUrl)
            chefName.text = currentItem.cuisine
            iconArrow.setAltImageResource(R.drawable.baseline_arrow_forward_24)
        }
    }
}