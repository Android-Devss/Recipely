package com.example.recipely.ui.homeFragment

import android.view.LayoutInflater
import android.view.ViewGroup
import coil.load
import com.example.recipely.R
import com.example.recipely.data.source.model.Recipe
import com.example.recipely.databinding.ItemEditorHomeBinding
import com.example.recipely.ui.base.BaseAdapter

class EditorsAdapter(
    editorsRecipeList: List<Recipe>,
) : BaseAdapter<Recipe,ItemEditorHomeBinding>(editorsRecipeList) {


    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> ItemEditorHomeBinding
        get() = ItemEditorHomeBinding::inflate

    override fun onBindViewHolder(
        holder: BaseViewHolder<ItemEditorHomeBinding>,
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