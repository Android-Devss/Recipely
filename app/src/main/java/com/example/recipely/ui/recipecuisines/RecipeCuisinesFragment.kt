package com.example.recipely.ui.recipecuisines

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.recipely.data.repository.RepositoryImp
import com.example.recipely.data.source.DataSourceImp
import com.example.recipely.databinding.FragmentRecipeCuisinesBinding
import com.example.recipely.domain.usecase.GetCuisinesUseCase
import com.example.recipely.ui.base.BaseFragment
import com.example.recipely.ui.recipecuisines.cuisinesdetails.CuisinesDetailsAdapter
import com.example.recipely.ui.recipecuisines.cuisinesdetails.RecipeCuisinesDetailsFragment
import com.example.recipely.util.CsvParser
import com.example.recipely.util.addFragment
import com.example.recipely.util.replaceFragment

class RecipeCuisinesFragment: BaseFragment<FragmentRecipeCuisinesBinding>(),CuisinesAdapter.CuisinesInteractionListener {
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentRecipeCuisinesBinding = FragmentRecipeCuisinesBinding::inflate
    override val logTag: String = this.javaClass.simpleName

    private lateinit var cuisinesAdapter: CuisinesAdapter
    private val dataSource by lazy { DataSourceImp(requireContext(), CsvParser()) }
    private val repository by lazy { RepositoryImp(dataSource) }
    private val cuisines: GetCuisinesUseCase by lazy {
        GetCuisinesUseCase(repository)
    }

    override fun initialize() {
        val cuisineItems = cuisines()
        cuisinesAdapter = CuisinesAdapter(cuisineItems,this)
        binding?.recyclerCuisine?.adapter = cuisinesAdapter
    }

    override fun addCallbacks() {
    }

    override fun onClickCuisine(recipeName : String) {
        val recipeCuisinesDetailsFragment =RecipeCuisinesDetailsFragment.newInstance(recipeName)
        replaceFragment(recipeCuisinesDetailsFragment)
    }
}