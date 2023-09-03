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
import com.example.recipely.util.CsvParser

class RecipeCuisinesFragment: BaseFragment<FragmentRecipeCuisinesBinding>() {
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentRecipeCuisinesBinding = FragmentRecipeCuisinesBinding::inflate
    override val logTag: String = this.javaClass.simpleName

    private lateinit var cuisinesAdapter: CuisinesAdapter
    private val dataSource by lazy { DataSourceImp(requireContext(), CsvParser()) }
    private val repository by lazy { RepositoryImp(dataSource) }
    private val cuisines: GetCuisinesUseCase by lazy {
        GetCuisinesUseCase(repository)
    }

    override fun onViewCreated(view : View, savedInstanceState : Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
    }


    override fun initialize() {
        val cuisineItems = cuisines()
        cuisinesAdapter = CuisinesAdapter(cuisineItems)
        binding?.recyclerCuisine?.adapter = cuisinesAdapter
    }

    override fun addCallbacks() {
    }

}