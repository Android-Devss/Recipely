package com.example.recipely.ui.cuisinesdetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.recipely.data.repository.RepositoryImp
import com.example.recipely.data.source.DataSourceImp
import com.example.recipely.databinding.FragmentRecipeCuisinesDetailsBinding
import com.example.recipely.domain.enums.SeeAllTypes
import com.example.recipely.domain.usecase.cuisine.GetCuisineRecipesUseCase
import com.example.recipely.ui.base.BaseFragment
import com.example.recipely.ui.home.HomeAdapter
import com.example.recipely.ui.recipecuisines.RecipeCuisinesFragment
import com.example.recipely.ui.recipedetails.RecipeDetailsFragment
import com.example.recipely.util.CsvParser
import com.example.recipely.util.replaceFragment

class RecipeCuisinesDetailsFragment : BaseFragment<FragmentRecipeCuisinesDetailsBinding>(),
    HomeAdapter.HomeInteractionListener {
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentRecipeCuisinesDetailsBinding =
        FragmentRecipeCuisinesDetailsBinding::inflate
    override val logTag: String = this.javaClass.simpleName

    private lateinit var cuisinesDetailsAdapter: CuisinesDetailsAdapter
    private val dataSource by lazy { DataSourceImp(requireContext(), CsvParser()) }
    private val repository by lazy { RepositoryImp(dataSource) }
    private val getCuisineRecipesUseCase: GetCuisineRecipesUseCase by lazy {
        GetCuisineRecipesUseCase(repository)
    }
    private val recipeCuisinesFragment by lazy { RecipeCuisinesFragment() }


    override fun initialize() {
        val cuisineDetailsItems = getCuisineRecipesUseCase(getCuisineName() ?: "")
        cuisinesDetailsAdapter = CuisinesDetailsAdapter(cuisineDetailsItems, this)
        binding?.recyclerCuisines?.adapter = cuisinesDetailsAdapter
    }


    override fun addCallbacks() {
        binding?.arrowBackToCuisines?.setOnClickListener {
            replaceFragment(recipeCuisinesFragment)
        }
    }

    private fun getCuisineName(): String? {
        return arguments?.getString(CUISINE_NAME)
    }

    companion object {
        private const val CUISINE_NAME = "cuisineName"
        fun newInstance(cuisineName: String) = RecipeCuisinesDetailsFragment().apply {
            arguments = Bundle().apply {
                putString(CUISINE_NAME, cuisineName)
            }
        }
    }

    override fun onClickRecipe(recipeName: String) {
        val recipeDetails = RecipeDetailsFragment.newInstance(recipeName)
        replaceFragment(recipeDetails)
    }

    override fun onClickHomeSeeAll(type: SeeAllTypes) {
        TODO("Not yet implemented")
    }
}