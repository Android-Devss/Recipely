package com.example.recipely.ui.seeAllHome


import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.recipely.data.repository.RepositoryImp
import com.example.recipely.data.source.DataSourceImp
import com.example.recipely.data.source.model.Recipe
import com.example.recipely.databinding.FragmentSeeAllBinding
import com.example.recipely.domain.usecase.home.GetPopularRecipesUseCase
import com.example.recipely.ui.base.BaseFragment
import com.example.recipely.util.CsvParser


class SeeAllFragment : BaseFragment<FragmentSeeAllBinding>(),
    SeeAllAdapter.RecipeInteractionListener {
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentSeeAllBinding =
        FragmentSeeAllBinding::inflate

    override val logTag: String = this.javaClass.simpleName
    private val dataSource by lazy { DataSourceImp(requireContext(), CsvParser()) }
    private val repository by lazy { RepositoryImp(dataSource) }
    private val getPopularRecipesUseCase by lazy { GetPopularRecipesUseCase(repository) }
    private lateinit var adapter: SeeAllAdapter

    override fun initialize() {
        val popularRecipes = getPopularRecipesUseCase(20)

        adapter = SeeAllAdapter(popularRecipes)
        binding?.recyclerRecipes?.adapter = adapter
    }

    override fun addCallbacks() {

    }

    override fun onClickRecipe(recipeId: Int) {
    }
}