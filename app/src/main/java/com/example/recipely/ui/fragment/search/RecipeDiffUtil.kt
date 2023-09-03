package com.example.recipely.ui.fragment.search

import androidx.recyclerview.widget.DiffUtil
import com.example.recipely.data.source.model.Recipe

class RecipeDiffUtil(
    private val oldRecipesLis: List<Recipe>,
    private val newRecipesList: List<Recipe>
) :
    DiffUtil.Callback() {
    override fun getOldListSize() = oldRecipesLis.size

    override fun getNewListSize() = newRecipesList.size
    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return (oldRecipesLis[oldItemPosition].recipeName == newRecipesList[newItemPosition].recipeName
                || oldRecipesLis[oldItemPosition].cuisine == newRecipesList[newItemPosition].cuisine)
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return true
    }
}