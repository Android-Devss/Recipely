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
import com.example.recipely.domain.usecase.home.GetFastRecipesUseCase
import com.example.recipely.domain.usecase.home.GetPopularRecipesUseCase
import com.example.recipely.ui.base.BaseFragment
import com.example.recipely.ui.recipedetails.RecipeDetailsFragment
import com.example.recipely.util.CsvParser
import com.example.recipely.util.replaceFragment


@Suppress("DEPRECATION")
class SeeAllFragment : BaseFragment<FragmentSeeAllBinding>(),
    SeeAllAdapter.RecipeInteractionListener {
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentSeeAllBinding =
        FragmentSeeAllBinding::inflate

    override val logTag: String = this.javaClass.simpleName

    private val dataSource by lazy { DataSourceImp(requireContext(), CsvParser()) }
    private val repository by lazy { RepositoryImp(dataSource) }
    private lateinit var recipe: List<Recipe>
    private val getPopularRecipesUseCase by lazy { GetPopularRecipesUseCase(repository) }
    private val getFastRecipesUseCase by lazy { GetFastRecipesUseCase(repository) }
    private lateinit var adapter: SeeAllAdapter
    private lateinit var recipeType:SeeAllTypes
    override fun initialize() {
        returnListType()
        getListContent()
        adapter = SeeAllAdapter(recipe,this)
        binding?.recyclerRecipes?.adapter = adapter
    }


    private fun getListContent(){
        recipe = when (recipeType){
            SeeAllTypes.TYPE_HOME_POPULAR
            -> {
                getPopularRecipesUseCase(30)
            }

            SeeAllTypes.TYPE_HOME_EASY
            -> {
                getFastRecipesUseCase()
            }
        }
    }
    companion object {
        const val RECIPE_LIST_TYPE="RecipeList"
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
        replaceFragment(  RecipeDetailsFragment.newInstance(recipeName))
    }
      override fun onClickRecipeName(recipeName: String) {
        startRecipeDetailsFragment(recipeName)
    }



}