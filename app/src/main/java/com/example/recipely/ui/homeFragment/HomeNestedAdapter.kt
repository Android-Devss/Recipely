package com.example.recipely.ui.homeFragment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recipely.R
import com.example.recipely.data.source.model.Recipe
import com.example.recipely.databinding.EditorRecyclerviewLayoutBinding
import com.example.recipely.databinding.PopularRecyclerviewLayoutBinding
import com.example.recipely.domain.HomeItem
import com.example.recipely.domain.enums.HomeItemType
import com.example.recipely.domain.enums.HomeRecyclerType


class HomeNestedAdapter(private var listHomeItem : List<HomeItem<Any>>
,private val seeAllListener: HomeSeeAllListener) :
    RecyclerView.Adapter<HomeNestedAdapter.BaseViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        when (viewType) {
            DataType.POPULAR_RECIPE ->
            {

                val view = LayoutInflater.from(parent.context).inflate(
                    R.layout.home_popular_card,
                    parent,
                    false)
                return PopularRcipesViewHolder(view)
            }

            DataType.EDITORS_CHOISE ->
            {
                val view = LayoutInflater.from(parent.context).inflate(
                    R.layout.home_editors_card,
                    parent,
                    false)
                return EditorsViewHolder(view)


            }

        else -> throw java.lang.Exception("Exception in determining viewCard")
    }
}

    override fun getItemCount() = listHomeItem.size

    override fun onBindViewHolder(holder : BaseViewHolder, position : Int) {
        when(holder)
        {
            is PopularRcipesViewHolder ->
            {
                onBindingPopularRcipesViewHolder(holder,position)
            }
            is EditorsViewHolder->
            {
                onBindingEditorRcipesViewHolder(holder,position)
            }
        }
    }
private fun onBindingPopularRcipesViewHolder(holder: PopularRcipesViewHolder, position: Int){
    val poplarItemsList=listHomeItem[position].item as List<Recipe>
    val adapter = PopularRecipesAdapter(poplarItemsList)
    holder.binding.title.text=(R.string.popular).toString()
    holder.binding.seeAll.text=(R.string.see_all).toString()
    holder.binding.recyclerviewChild.adapter=adapter
    holder.binding.seeAll.setOnClickListener {
        seeAllListener.onClickSeeAll(HomeRecyclerType.HOME_POPULAR_TYPE)

        }

    }

    private fun onBindingEditorRcipesViewHolder(holder: EditorsViewHolder, position: Int){
        val editorItemList=listHomeItem[position].item as List<Recipe>
        val adapter = EditorsAdapter(editorItemList)
        holder.binding.title.text=(R.string.editors).toString()
        holder.binding.seeAll.text=(R.string.see_all).toString()
        holder.binding.recyclerview.adapter = adapter
        holder.binding.seeAll.setOnClickListener {
            seeAllListener.onClickSeeAll(HomeRecyclerType.HOME_EDITORS_TYPE)


        }

    }
    override fun getItemViewType(position: Int ) : Int {
        return when (listHomeItem[position].type) {
            HomeItemType.HOME_POPULAR_TYPE ->
                DataType.EDITORS_CHOISE

            HomeItemType.HOME_EDITORS_TYPE ->
                DataType.POPULAR_RECIPE
        }
    }

    abstract class BaseViewHolder(viewItem : View) : RecyclerView.ViewHolder(viewItem)

    class PopularRcipesViewHolder(viewItem : View) : BaseViewHolder(viewItem) {
        val binding = PopularRecyclerviewLayoutBinding.bind(viewItem)
    }
    class EditorsViewHolder(viewItem : View) : BaseViewHolder(viewItem) {
        val binding= EditorRecyclerviewLayoutBinding.bind(viewItem)

    }



}
class DataType {
    companion object {
        const val POPULAR_RECIPE = 1
        const val EDITORS_CHOISE = 2
    }
}
interface HomeSeeAllListener {
    fun onClickSeeAll(type: HomeRecyclerType)
}

