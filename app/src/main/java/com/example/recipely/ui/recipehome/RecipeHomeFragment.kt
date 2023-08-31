package com.example.recipely.ui.recipehome

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.recipely.data.repository.RepositoryImp
import com.example.recipely.data.source.DataSourceImp
import com.example.recipely.data.source.model.Recipe
import com.example.recipely.databinding.FragmentRecipeHomeBinding
import com.example.recipely.ui.base.BaseFragment
import com.example.recipely.ui.home.HomeAdapter
import com.example.recipely.util.CsvParser

class RecipeHomeFragment : BaseFragment<FragmentRecipeHomeBinding>() {
    override val bindingInflater : (LayoutInflater, ViewGroup?, Boolean) -> FragmentRecipeHomeBinding
        get() = FragmentRecipeHomeBinding::inflate
    override val logTag : String = this.javaClass.simpleName
    private lateinit var homeAdapter : HomeAdapter

    private val dataSource by lazy { DataSourceImp(requireContext(), CsvParser()) }
    private val repository by lazy { RepositoryImp(dataSource) }
    override fun onViewCreated(view : View, savedInstanceState : Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        homeAdapter = HomeAdapter(repository.getAllRecipes())
        binding?.recyclerViewHome?.adapter = homeAdapter    }

    override fun initialize() {    }

    override fun addCallbacks() {
        TODO("Not yet implemented")
    }
}
