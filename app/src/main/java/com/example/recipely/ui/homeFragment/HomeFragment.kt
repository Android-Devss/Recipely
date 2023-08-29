package com.example.recipely.ui.homeFragment

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.recipely.data.source.GetCsvDataSource
import com.example.recipely.data.source.DataSource
import com.example.recipely.data.source.DataSourceImp
import com.example.recipely.databinding.FragmentHomeBinding
import com.example.recipely.domain.HomeItem
import com.example.recipely.ui.base.BaseFragment
import com.example.recipely.util.CsvParser

class HomeFragment : BaseFragment<FragmentHomeBinding>() {

    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentHomeBinding =
        FragmentHomeBinding::inflate
    private val dataSource by lazy { GetCsvDataSource(requireContext(), CsvParser()) }
    private val dataManager: DataSource by lazy { DataSourceImp(requireContext(),dataSource) }

    private val itemList: MutableList<HomeItem<Any>> = mutableListOf()

    override val logTag: String = this.javaClass.simpleName

    override fun initialize() {
        val popularRecipes = dataManager.getPopularRecipes().distinct().take(14)
        val editorsList = dataManager.getEasyRecipes().distinct().take(14)

        itemList.add(HomeItem(popularRecipes,1))
        itemList.add(HomeItem(editorsList,2))
        binding?.parentRecyclerView?.adapter= HomeNestedAdapter(itemList)


//        val adapter = HomeNestedAdapter(itemList)
//        binding?.parentRecyclerView?.adapter = adapter
    }

    override fun addCallbacks() {
    }
}

