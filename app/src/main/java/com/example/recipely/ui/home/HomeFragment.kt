package com.example.recipely.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.recipely.data.repository.RepositoryImp
import com.example.recipely.data.source.DataSourceImp
import com.example.recipely.databinding.FragmentHomeBinding
import com.example.recipely.domain.HomeItem
import com.example.recipely.domain.Repository
import com.example.recipely.domain.usecase.home.GetEasyRecipesUseCase
import com.example.recipely.domain.usecase.home.GetPopularRecipesUseCase
import com.example.recipely.ui.base.BaseFragment
import com.example.recipely.util.CsvParser

class HomeFragment : BaseFragment<FragmentHomeBinding>() {

    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentHomeBinding =
        FragmentHomeBinding::inflate
    override val logTag: String = this.javaClass.simpleName
    private val dataSource by lazy { DataSourceImp(requireContext(), CsvParser()) }
    private val repository: Repository by lazy { RepositoryImp(dataSource) }
    private val itemList: MutableList<HomeItem<Any>> = mutableListOf()
    private val getPopularRecipesUseCase: GetPopularRecipesUseCase by lazy {
        GetPopularRecipesUseCase(repository)
    }
    private val getEasyRecipesUseCase: GetEasyRecipesUseCase by lazy {
        GetEasyRecipesUseCase(repository)
    }

    override fun initialize() {
        val popularRecipes = getPopularRecipesUseCase()
        val editorsList = getEasyRecipesUseCase()
        log(popularRecipes)
        log(editorsList)

        itemList.add(HomeItem(popularRecipes, 1))
        itemList.add(HomeItem(editorsList, 2))

        val adapter = HomeAdapter(itemList)
        binding?.parentRecyclerView?.adapter = adapter
    }

    override fun addCallbacks() {

    }
}

