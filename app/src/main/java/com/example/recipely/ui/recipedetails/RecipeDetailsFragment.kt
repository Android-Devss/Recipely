package com.example.recipely.ui.recipedetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import coil.load
import com.example.recipely.R
import com.example.recipely.data.repository.RepositoryImp
import com.example.recipely.data.source.DataSourceImp
import com.example.recipely.databinding.FragmentRecipeDetailsBinding
import com.example.recipely.domain.usecase.GetRecipeById
import com.example.recipely.ui.base.BaseFragment
import com.example.recipely.util.CsvParser
import com.example.recipely.util.loadImageWithPlaceholderAndCrossFade
import com.example.recipely.util.toCountFormat
import com.example.recipely.util.toIngredientsFormat
import com.example.recipely.util.toInstructionsFormat
import com.example.recipely.util.toTimeFormat


class RecipeDetailsFragment : BaseFragment<FragmentRecipeDetailsBinding>() {
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) ->
    FragmentRecipeDetailsBinding = FragmentRecipeDetailsBinding::inflate
    override val logTag: String = this::class.java.simpleName

    private val dataSource by lazy { DataSourceImp(requireContext(), CsvParser()) }
    private val repository by lazy { RepositoryImp(dataSource) }
    private val recipe by lazy { GetRecipeById(repository).invoke(getRecipeId() ?: 0) }


    override fun initialize() {
        displayRecipeDetails()
    }

    override fun addCallbacks() {

    }

    private fun displayRecipeDetails() {
        binding?.apply {
            recipeDetailsName.text = recipe.recipeName
            recipeDetailsTime.text = recipe.totalTimeInMinutes.toTimeFormat()
            recipeDetailsCuisine.text = recipe.cuisine
            recipeDetailsIngredientsCount.text = recipe.ingredientsCount.toCountFormat()
            recipeDetailsIngredients.text = recipe.ingredients.toIngredientsFormat()
            recipeDetailsImage.loadImageWithPlaceholderAndCrossFade(recipe.imageUrl)
            recipeDetailsInstructions.text = recipe.instructions.toInstructionsFormat()
            recipeDetailsHealthIngredients.text = recipe.cleanedIngredients.toIngredientsFormat()
        }
    }

    private fun getRecipeId(): Int? {
        return arguments?.getInt(ID)
    }

    companion object {
        private const val ID = "id"
        fun newInstance(id: Int) = RecipeDetailsFragment().apply {
            arguments = Bundle().apply {
                putInt(ID, id)
            }
        }
    }
}