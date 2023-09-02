package com.example.recipely.ui.fragment.search

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import com.example.recipely.R
import com.example.recipely.data.repository.RepositoryImp
import com.example.recipely.data.source.DataSourceImp
import com.example.recipely.databinding.FragmentSearchBinding
import com.example.recipely.domain.usecase.search.SearchUseCase
import com.example.recipely.ui.base.BaseFragment
import com.example.recipely.util.CsvParser

class SearchFragment : BaseFragment<FragmentSearchBinding>(), ActionListener,
    SearchView.OnQueryTextListener, SearchAdapter.RecipeInteractionListener {

    private val dataSource by lazy { DataSourceImp(requireContext(), CsvParser()) }
    private val repository by lazy { RepositoryImp(dataSource) }
    private lateinit var adapter: SearchAdapter
    private val searchUseCase: SearchUseCase = SearchUseCase(repository)

    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentSearchBinding
        get() = FragmentSearchBinding::inflate
    override val logTag: String
        get() = this::class.java.simpleName

    override fun initialize() {
        adapter = SearchAdapter(this)
    }

    override fun addCallbacks() {
        binding?.search?.setOnQueryTextListener(this)
    }

    private fun searchByQueryAndSetDataInAdapter(query: String?) {
        query?.let {
            binding.apply {
                visibilityOfImageAndRecyclerInSearchFragment(it)
                if (it.isNotEmpty()) {
                    setDataOnAdapter(it)
                }
            }
        }
    }

    private fun setDataOnAdapter(query: String) {
        val resultOfSearch = searchUseCase.searchAboutRecipes(query)
        adapter.setData(resultOfSearch)
        binding?.recyclerviewSearchList?.adapter = adapter
    }

    private fun visibilityOfImageAndRecyclerInSearchFragment(query: String?) {
        val result = query?.let { searchUseCase.searchAboutRecipes(it) }
        binding?.apply {
            query?.let { visibility(it) }
            if (query?.isNotEmpty() == true) recyclerviewSearchList.show() else recyclerviewSearchList.hide()
            if (result?.isEmpty() == true) {
                tvDiscover.show()
                imgSearchAnimi.show()
                tvInfo.show()
                tvDiscover.text =
                    getString(R.string.no_recipes)
                tvInfo.text = getString(R.string.enter_valid_data)
                imgSearchAnimi.hide()
                imgSearchNotFound.show()
            } else {
                tvDiscover.text = getString(R.string.discover_recipes)
                tvInfo.text = getString(R.string.search_about_recipes)
            }
        }
    }

    private fun FragmentSearchBinding.visibility(query: String) {
        when (query.isEmpty()) {
            true -> {
                imgSearchAnimi.show()
                tvDiscover.show()
                tvInfo.show()
                imgSearchNotFound.hide()
            }

            else -> {
                imgSearchAnimi.hide()
                tvDiscover.hide()
                tvInfo.hide()
                imgSearchNotFound.hide()
            }
        }
    }

    override fun onRecipeClick(id: Int) {
        TODO("Not yet implemented")
    }

    override fun onQueryTextSubmit(query: String?): Boolean {
        query?.let { searchByQueryAndSetDataInAdapter(it) }
        return true
    }

    override fun onQueryTextChange(newText: String?): Boolean {
        newText?.let { searchByQueryAndSetDataInAdapter(it) }
        return true
    }

    override fun onClickRecipe(recipeId: Int) {
        TODO("Not yet implemented")
    }

    private fun View.hide() {
        visibility = View.INVISIBLE
    }

    private fun View.show() {
        visibility = View.VISIBLE
    }
}