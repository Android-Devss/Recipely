package com.example.recipely.ui.homeFragment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.net.toUri
import coil.load
import com.example.recipely.databinding.HomePopularCardBinding
import com.example.recipely.domain.PopularRecipesModel

class PopularRecipesAdapter (recipes: List<PopularRecipesModel>)
    : HomeBaseAdapter<PopularRecipesModel, HomePopularCardBinding>(recipes) {
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
