package com.example.recipely.ui.recipecuisines.cuisinesdetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.recipely.data.repository.RepositoryImp
import com.example.recipely.data.source.DataSourceImp
import com.example.recipely.databinding.FragmentRecipeCuisinesDetailsBinding
import com.example.recipely.domain.enums.SeeAllTypes
import com.example.recipely.domain.usecase.home.GetPopularRecipesUseCase
import com.example.recipely.ui.base.BaseFragment
import com.example.recipely.ui.recipecuisines.RecipeCuisinesFragment
import com.example.recipely.ui.recipedetails.RecipeDetailsFragment
import com.example.recipely.ui.recipehome.HomeAdapter
import com.example.recipely.util.CsvParser
import com.example.recipely.util.addFragment

class RecipeCuisinesDetailsFragment : BaseFragment<FragmentRecipeCuisinesDetailsBinding>(),
    HomeAdapter.HomeInteractionListener {
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentRecipeCuisinesDetailsBinding =
        FragmentRecipeCuisinesDetailsBinding::inflate
    override val logTag: String = this.javaClass.simpleName

    private lateinit var cuisinesDetailsAdapter: CuisinesDetailsAdapter
    private val dataSource by lazy { DataSourceImp(requireContext(), CsvParser()) }
    private val repository by lazy { RepositoryImp(dataSource) }
    private val getPopularRecipesUseCase by lazy { GetPopularRecipesUseCase(repository) }
    private val recipeCuisinesFragment by lazy { RecipeCuisinesFragment() }


    override fun initialize() {
        val cuisineDetailsItems = getPopularRecipesUseCase(300)
        cuisinesDetailsAdapter = CuisinesDetailsAdapter(cuisineDetailsItems, this)
        binding?.recyclerCuisines?.adapter = cuisinesDetailsAdapter
    }


    override fun addCallbacks() {
        binding?.arrowBackToCuisines?.setOnClickListener {
            addFragment(recipeCuisinesFragment)
        }
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
        addFragment(recipeDetails)
    }

    override fun onClickHomeSeeAll(type: SeeAllTypes) {
        TODO("Not yet implemented")
    }
}