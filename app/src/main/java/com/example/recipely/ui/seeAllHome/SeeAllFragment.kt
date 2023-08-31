package com.example.recipely.ui.seeAllHome


import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.recipely.data.source.DataSource
import com.example.recipely.data.source.DataSourceImp
import com.example.recipely.data.source.GetCsvDataSource
import com.example.recipely.data.source.model.Recipe
import com.example.recipely.databinding.FragmentSeeAllBinding
import com.example.recipely.domain.enums.HomeRecyclerType
import com.example.recipely.ui.base.BaseFragment
import com.example.recipely.util.CsvParser


class SeeAllFragment : BaseFragment<FragmentSeeAllBinding>(),SeeAllAdapter.RecipeInteractionListener
{
    private val dataSource by lazy { GetCsvDataSource(requireContext(), CsvParser()) }

    private val dataManager: DataSource by lazy { DataSourceImp(requireContext(),dataSource) }


    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentSeeAllBinding =
        FragmentSeeAllBinding::inflate

    override val logTag: String = this.javaClass.simpleName

    private lateinit var recyclerType:HomeRecyclerType
    private lateinit var adapter:SeeAllAdapter
    private lateinit var recipes:List<Recipe>

    override fun initialize() {
  //     getRecipesType()
  //     returnRecyclerType()
        val popularRecipes = dataManager.getPopularRecipes().distinct().take(50)
        adapter = SeeAllAdapter(popularRecipes)
        binding?.recyclerRecipes?.adapter = adapter

    }

    override fun addCallbacks() {
    }

    override fun onClickRecipe(recipeId: Int) {
        TODO("Not yet implemented")
    }
}

