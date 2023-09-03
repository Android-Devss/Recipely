package com.example.recipely.ui.recipecuisines.cuisinesdetails

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.recipely.data.repository.RepositoryImp
import com.example.recipely.data.source.DataSourceImp
import com.example.recipely.databinding.FragmentRecipeCuisinesBinding
import com.example.recipely.databinding.FragmentRecipeCuisinesDetailsBinding
import com.example.recipely.databinding.FragmentRecipeDetailsBinding
import com.example.recipely.domain.usecase.GetCuisinesUseCase
import com.example.recipely.domain.usecase.home.GetPopularRecipesUseCase
import com.example.recipely.ui.base.BaseFragment
import com.example.recipely.util.CsvParser

class RecipeCuisinesDetailsFragment: BaseFragment<FragmentRecipeCuisinesDetailsBinding>() {
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentRecipeCuisinesDetailsBinding =
        FragmentRecipeCuisinesDetailsBinding::inflate
    override val logTag : String = this.javaClass.simpleName

    private lateinit var cuisinesDetailsAdapter: CuisinesDetailsAdapter
    private val dataSource by lazy { DataSourceImp(requireContext(), CsvParser()) }
    private val repository by lazy { RepositoryImp(dataSource) }
    private val cuisines: GetCuisinesUseCase by lazy { GetCuisinesUseCase(repository) }
    private val getPopularRecipesUseCase by lazy { GetPopularRecipesUseCase(repository) }


    override fun initialize() {
        val cuisineDetailsItems = getPopularRecipesUseCase(300)
        cuisinesDetailsAdapter = CuisinesDetailsAdapter(cuisineDetailsItems)
        binding?.recyclerCuisines?.adapter = cuisinesDetailsAdapter
    }

    override fun addCallbacks() {
    }
}