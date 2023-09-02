package com.example.recipely.ui.recipehome

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.recipely.R
import com.example.recipely.data.repository.RepositoryImp
import com.example.recipely.data.source.DataSourceImp
import com.example.recipely.databinding.FragmentRecipeHomeBinding
import com.example.recipely.domain.usecase.home.GetPopularRecipesUseCase
import com.example.recipely.domain.usecase.home.GetEasyRecipesUseCase
import com.example.recipely.ui.base.BaseFragment
import com.example.recipely.ui.recipedetails.RecipeDetailsFragment
import com.example.recipely.ui.recipehome.homemodel.HomeItem
import com.example.recipely.ui.recipehome.homemodel.HomeItemType
import com.example.recipely.util.CsvParser

class RecipeHomeFragment : BaseFragment<FragmentRecipeHomeBinding>(),OnHomeClickListener {
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentRecipeHomeBinding
        get() = FragmentRecipeHomeBinding::inflate
    override val logTag: String = this.javaClass.simpleName

    private lateinit var homeAdapter: HomeAdapter
    private val dataSource by lazy { DataSourceImp(requireContext(), CsvParser()) }
    private val repository by lazy { RepositoryImp(dataSource) }
    private val horizontalItems: GetPopularRecipesUseCase by lazy { GetPopularRecipesUseCase(repository) }
    private val verticaItems: GetEasyRecipesUseCase by lazy { GetEasyRecipesUseCase(repository) }

    override fun initialize() {
        val itemsList: MutableList<HomeItem<Any>> = mutableListOf()

        itemsList.add(HomeItem(R.string.popular_recipes, HomeItemType.ITEM_POPULAR))
        itemsList.add(HomeItem(horizontalItems(10), HomeItemType.ITEM_HORIZONTAL))
        itemsList.add(HomeItem(R.string.easy_to_cook, HomeItemType.ITEM_EASY_COOK))
        itemsList.add(HomeItem(verticaItems(20), HomeItemType.ITEM_VERTICAL))

        homeAdapter = HomeAdapter(itemsList,this)
        binding?.recyclerViewHome?.adapter = homeAdapter
    }

    override fun addCallbacks() {

    }

    override fun onRecipeClicked(id: Int) {
        val detailsFragment = RecipeDetailsFragment.newInstance(id)
        replaceFragment(detailsFragment)
    }
    private fun replaceFragment(fragment: Fragment) {
        requireActivity().supportFragmentManager.beginTransaction()
            .add(R.id.fragment_container, fragment)
            .addToBackStack(this.javaClass.simpleName)
            .commit()
    }
}

