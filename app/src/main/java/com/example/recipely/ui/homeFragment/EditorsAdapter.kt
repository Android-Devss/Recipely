package com.example.recipely.ui.homeFragment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.net.toUri
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
        val uriImage = currentItem.recipeName.toUri()
        holder.binding.apply {
            recipeName.text = currentItem.recipeName
            recipeImage.setImageURI(uriImage)
            chefName.text=currentItem.cuisine
            iconArrow.setAltImageResource(R.drawable.baseline_arrow_forward_24)
        }
    }

}