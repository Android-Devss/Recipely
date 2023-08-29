package com.example.recipely.ui.homeFragment

import android.view.LayoutInflater
import android.view.ViewGroup
import coil.load
import com.example.recipely.R
import com.example.recipely.data.source.model.Recipe
import com.example.recipely.databinding.HomeEditorsCardBinding

class EditorsAdapter(
    editorsRecipeList: List<Recipe>,
) : HomeBaseAdapter<Recipe,HomeEditorsCardBinding>(editorsRecipeList) {


    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> HomeEditorsCardBinding
        get() = HomeEditorsCardBinding::inflate

    override fun onBindViewHolder(
        holder: BaseViewHolder<HomeEditorsCardBinding>,
        position: Int,
        currentItem: Recipe
    ) {
        holder.binding.apply {
            recipeName.text = currentItem.recipeName
            recipeImage.load(currentItem.imageUrl)
            chefName.text=currentItem.cuisine
            iconArrow.setAltImageResource(R.drawable.baseline_arrow_forward_24)
        }
    }

}