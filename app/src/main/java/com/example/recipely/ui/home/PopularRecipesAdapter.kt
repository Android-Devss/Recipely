package com.example.recipely.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import coil.load
import com.example.recipely.databinding.HomePopularCardBinding
import com.example.recipely.domain.PopularRecipesModel
import com.example.recipely.ui.base.BaseAdapter

class PopularRecipesAdapter(recipes: List<PopularRecipesModel>) :
    BaseAdapter<PopularRecipesModel, HomePopularCardBinding>(recipes) {
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> HomePopularCardBinding
        get() = HomePopularCardBinding::inflate

    override fun onBindViewHolder(
        holder: BaseViewHolder<HomePopularCardBinding>,
        position: Int,
        currentItem: PopularRecipesModel
    ) {
        holder.binding.apply {
            recipeName.text = currentItem.recipeName
            recipeImage.load(currentItem.recipeImageUrl)
        }
    }
}
