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
import com.example.recipely.domain.PopularRecipesModel


class HomeNestedAdapter(private var listHomeItem : List<HomeItem<Any>>) :
    RecyclerView.Adapter<HomeNestedAdapter.BaseViewHolder>() {

    override fun onCreateViewHolder(parent : ViewGroup, viewType : Int) : BaseViewHolder {
        when (viewType) {
            DataType.EDITORS_CHOISE -> {

                val view = LayoutInflater.from(parent.context).inflate(
                    R.layout.home_popular_card,
                    parent,
                    false
                )
                return PopularRcipesViewHolder(view)
            }

            DataType. EDITORS_CHOISE -> {
                val view = LayoutInflater.from(parent.context).inflate(
                    R.layout.home_editors_card,
                    parent,
                    false
                )
                return EditorsViewHolder(view)
            }

        }
        return super.createViewHolder(parent, viewType)
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
fun onBindingPopularRcipesViewHolder(holder: PopularRcipesViewHolder,position: Int){
    val poplarItemsList=listHomeItem[position].item as List<PopularRecipesModel>
    val adapter = PopularRecipesAdapter(poplarItemsList)
    holder.binding.recyclerviewChild.adapter = adapter
}

    fun onBindingEditorRcipesViewHolder(holder: EditorsViewHolder,position: Int){
        val poplarItemsList=listHomeItem[position].item as List<Recipe>
        val adapter = EditorsAdapter(poplarItemsList)
        holder.binding.recyclerviewChild.adapter = adapter
    }
    override fun getItemViewType(position : Int) : Int {
        return when (position) {
            1 -> {
               DataType.EDITORS_CHOISE
            }

            2 -> {
              DataType.POPULAR_RECIPE
            }


            else -> 0
        }
    }

    abstract class BaseViewHolder(viewItem : View) : RecyclerView.ViewHolder(viewItem)

    class PopularRcipesViewHolder(viewItem : View) : BaseViewHolder(viewItem) {
        val binding = PopularRecyclerviewLayoutBinding.bind(viewItem)
    }

    class EditorsViewHolder(viewItem : View) : BaseViewHolder(viewItem) {
        val binding = EditorRecyclerviewLayoutBinding.bind(viewItem)
    }
}
class DataType {
    companion object {
        const val POPULAR_RECIPE = 1
        const val EDITORS_CHOISE = 2


    }
}