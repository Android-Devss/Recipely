package com.example.recipely.ui.home

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


class HomeAdapter(private var listHomeItem: List<HomeItem<Any>>) :
    RecyclerView.Adapter<HomeAdapter.BaseViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        return when (viewType) {
            POPULAR_RECIPE -> {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.home_editors_card, parent, false)
                PopularRecipesViewHolder(view)
            }

            EDITORS_CHOICE -> {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.home_popular_card, parent, false)
                EditorsViewHolder(view)
            }

            else -> throw Exception("Error with view")
        }
    }

    override fun getItemCount() = listHomeItem.size

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        when (holder) {
            is PopularRecipesViewHolder -> {
                onBindingPopularRecipesViewHolder(holder, position)
            }

            is EditorsViewHolder -> {
                onBindingEditorRecipesViewHolder(holder, position)
            }
        }
    }

    private fun onBindingPopularRecipesViewHolder(holder: PopularRecipesViewHolder, position: Int) {
        val poplarItemsList = listHomeItem[position].item as List<PopularRecipesModel>
        val adapter = PopularRecipesAdapter(poplarItemsList)
        holder.binding.rvPopularRecipe.adapter = adapter
    }

    private fun onBindingEditorRecipesViewHolder(holder: EditorsViewHolder, position: Int) {
        val poplarItemsList = listHomeItem[position].item as List<Recipe>
        val adapter = EditorsAdapter(poplarItemsList)
        holder.binding.rvEditorChoice.adapter = adapter
    }

    override fun getItemViewType(position: Int): Int {
        return when (listHomeItem[position].type) {
            1 -> POPULAR_RECIPE
            2 -> EDITORS_CHOICE
            else -> 0
        }
    }

    abstract class BaseViewHolder(viewItem: View) : RecyclerView.ViewHolder(viewItem)

    class PopularRecipesViewHolder(viewItem: View) : BaseViewHolder(viewItem) {
        val binding = PopularRecyclerviewLayoutBinding.bind(viewItem)
    }

    class EditorsViewHolder(viewItem: View) : BaseViewHolder(viewItem) {
        val binding = EditorRecyclerviewLayoutBinding.bind(viewItem)
    }

    companion object {
        const val POPULAR_RECIPE = 1
        const val EDITORS_CHOICE = 2
    }
}