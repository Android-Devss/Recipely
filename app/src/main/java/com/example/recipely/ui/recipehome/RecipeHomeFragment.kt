package com.example.recipely.ui.recipehome

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.recipely.R
import com.example.recipely.data.repository.RepositoryImp
import com.example.recipely.data.source.DataSourceImp
import com.example.recipely.data.source.model.Recipe
import com.example.recipely.databinding.FragmentRecipeHomeBinding
import com.example.recipely.domain.usecase.GetHorizontalItems
import com.example.recipely.domain.usecase.GetVerticaItems
import com.example.recipely.ui.base.BaseFragment
import com.example.recipely.ui.recipehome.homemodel.HomeItem
import com.example.recipely.ui.recipehome.homemodel.HomeItemType
import com.example.recipely.util.CsvParser

class RecipeHomeFragment : BaseFragment<FragmentRecipeHomeBinding>() {
    override val bindingInflater : (LayoutInflater, ViewGroup?, Boolean) -> FragmentRecipeHomeBinding
        get() = FragmentRecipeHomeBinding::inflate
    override val logTag : String = this.javaClass.simpleName
    private lateinit var homeAdapter : HomeAdapter
    lateinit var  recipe:Recipe
    private val dataSource by lazy { DataSourceImp(requireContext(), CsvParser()) }
    private val repository by lazy { RepositoryImp(dataSource) }
    private val horizontalItems : GetHorizontalItems by  lazy { GetHorizontalItems(repository)}
    private val verticaItems : GetVerticaItems by  lazy { GetVerticaItems(repository)}

    override fun onViewCreated(view : View, savedInstanceState : Bundle?) {
        initialize()
     }

    override fun initialize() {
        val itemsList: MutableList<HomeItem<Any>> = mutableListOf()
        itemsList.add(HomeItem(R.string.popular_recipes, HomeItemType.ITEM_POPULAR))
        itemsList.add(HomeItem(horizontalItems.invoke(6), HomeItemType.ITEM_HORIZONTAL))
        itemsList.add(HomeItem(R.string.editor_s_choice, HomeItemType.ITEM_EDITOR_CHOICE))
        itemsList.add(HomeItem(verticaItems.invoke(), HomeItemType.ITEM_HORIZONTAL))
        homeAdapter = HomeAdapter(itemsList)
        binding?.recyclerViewHome?.adapter = homeAdapter
    }

    override fun addCallbacks() {
        TODO("Not yet implemented")
    }
    companion object {
        const val ITEM_POPULAR= 0
        const val ITEM_HORIZONTAL= 1
        const val ITEM_EDITOR_CHOICE= 2
        const val ITEM_VERTICAL =3
    }
}
