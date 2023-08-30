package com.example.recipely.ui.homeFragment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recipely.data.source.GetCsvDataSource
import com.example.recipely.data.source.DataSource
import com.example.recipely.data.source.DataSourceImp
import com.example.recipely.databinding.FragmentHomeBinding
import com.example.recipely.domain.HomeItem
import com.example.recipely.domain.enums.HomeItemType
import com.example.recipely.ui.base.BaseFragment
import com.example.recipely.util.CsvParser

class HomeFragment : BaseFragment<FragmentHomeBinding>() {
    private val dataSource by lazy { GetCsvDataSource(requireContext(), CsvParser()) }
    private val dataManager: DataSource by lazy { DataSourceImp(requireContext(),dataSource) }

    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentHomeBinding =
        FragmentHomeBinding::inflate

    private val itemList: MutableList<HomeItem<Any>> = mutableListOf()

    override val logTag: String = this.javaClass.simpleName
    private lateinit var adapter:HomeNestedAdapter
    private lateinit var adaptertest:PopularRecipesAdapter
    override fun initialize() {
        val popularRecipes = dataManager.getPopularRecipes().distinct().take(14)
        val editorsList = dataManager.getEasyRecipes().distinct().take(14)

        itemList.add(HomeItem(popularRecipes, HomeItemType.HOME_POPULAR_TYPE))
        itemList.add(HomeItem(editorsList,HomeItemType.HOME_EDITORS_TYPE))

        binding?.parentRecyclerView?.layoutManager = LinearLayoutManager(context)
        adapter = HomeNestedAdapter(itemList)
        binding?.parentRecyclerView?.adapter = adapter

        adaptertest= PopularRecipesAdapter(dataManager.getEasyRecipes())
        binding?.parentRecyclerView?.adapter = adaptertest

    }

    override fun addCallbacks() {
    }
}

