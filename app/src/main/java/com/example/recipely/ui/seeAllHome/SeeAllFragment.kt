package com.example.recipely.ui.seeAllHome


import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.recipely.data.repository.RepositoryImp
import com.example.recipely.data.source.DataSourceImp
import com.example.recipely.data.source.model.Recipe
import com.example.recipely.databinding.FragmentSeeAllBinding
import com.example.recipely.domain.enums.SeeAllTypes
import com.example.recipely.domain.usecase.seeall.GetAllEasyRecipesUseCase
import com.example.recipely.domain.usecase.seeall.GetAllPopularRecipesUseCase
import com.example.recipely.ui.base.BaseFragment
import com.example.recipely.ui.recipedetails.RecipeDetailsFragment
import com.example.recipely.util.CsvParser
import com.example.recipely.util.addFragment
import com.example.recipely.util.replaceFragment


@Suppress("DEPRECATION")
class SeeAllFragment : BaseFragment<FragmentSeeAllBinding>(),
    SeeAllAdapter.RecipeInteractionListener {
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentSeeAllBinding =
        FragmentSeeAllBinding::inflate
    override val logTag: String = this.javaClass.simpleName

    private val dataSource by lazy { DataSourceImp(requireContext(), CsvParser()) }
    private val repository by lazy { RepositoryImp(dataSource) }
    private val getPopularRecipesUseCase by lazy { GetAllPopularRecipesUseCase(repository) }
    private val getEasyRecipesUseCase by lazy { GetAllEasyRecipesUseCase(repository) }
    private lateinit var adapter: SeeAllAdapter
    private var recipeType: SeeAllTypes = SeeAllTypes.TYPE_HOME_POPULAR

    override fun initialize() {
        returnListType()

        adapter = SeeAllAdapter(getListContent(), this)
        binding?.recyclerRecipes?.adapter = adapter
    }


    private fun getListContent(): List<Recipe> {
        return when (recipeType) {
            SeeAllTypes.TYPE_HOME_POPULAR -> getPopularRecipesUseCase(100)
            SeeAllTypes.TYPE_HOME_EASY -> getEasyRecipesUseCase(100)
        }
    }

    companion object {
        const val RECIPE_LIST_TYPE = "RecipeList"
        fun newInstance(type: SeeAllTypes) =
            SeeAllFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(RECIPE_LIST_TYPE, type)
                }
            }
    }

    private fun returnListType(): SeeAllTypes {
        arguments?.let {
            recipeType = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                it.getParcelable(RECIPE_LIST_TYPE, SeeAllTypes::class.java)!!
            } else {
                it.getParcelable(RECIPE_LIST_TYPE)!!
            }
        }
        return recipeType
    }

    override fun addCallbacks() {

    }

    private fun startRecipeDetailsFragment(recipeName: String) {
        val recipeDetails = RecipeDetailsFragment.newInstance(recipeName)
        addFragment(recipeDetails)
    }

    override fun onClickRecipeName(recipeName: String) {
        startRecipeDetailsFragment(recipeName)
    }
}