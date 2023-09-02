package com.example.recipely.ui.recipehome

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recipely.R
import com.example.recipely.data.source.model.Recipe
import com.example.recipely.databinding.ItemEasyToCookHeaderBinding
import com.example.recipely.databinding.ItemPopularRecipeHeaderBinding
import com.example.recipely.databinding.LayoutEasyToCookRecipesBinding
import com.example.recipely.databinding.LayoutPopularRecipesBinding
import com.example.recipely.ui.recipehome.homemodel.HomeItem
import com.example.recipely.ui.recipehome.homemodel.HomeItemType

@Suppress("UNCHECKED_CAST")
class HomeAdapter(private var items: List<HomeItem<Any>>) :
    RecyclerView.Adapter<HomeAdapter.BaseViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return when (viewType) {
            ITEM_POPULAR -> {
                val view = inflater.inflate(R.layout.item_popular_recipe_header, parent, false)
                ItemPopularViewHolder(view)
            }

            ITEM_HORIZONTAL -> {
                val view = inflater.inflate(R.layout.layout_popular_recipes, parent, false)
                ItemHorizontalViewHolder(view)
            }

            ITEM_EDITOR_CHOICE -> {
                val view = inflater.inflate(R.layout.item_easy_to_cook_header, parent, false)
                ItemEditorChoiceViewHolder(view)
            }

            ITEM_VERTICAL -> {
                val view = inflater.inflate(R.layout.layout_easy_to_cook_recipes, parent, false)
                ItemVerticalViewHolder(view)
            }

            else -> throw Exception(" UNKNOWN VIEW TYPE")
        }
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        when (holder) {
            is ItemPopularViewHolder -> {
                holder.binding.apply {
                    popularRecipesViewAll.setOnClickListener { }
                }
            }

            is ItemEditorChoiceViewHolder -> {
                holder.binding.apply {
                    editorChoiceViewAll.setOnClickListener { }
                }
            }

            is ItemHorizontalViewHolder -> bindHorizontalItems(holder, position)
            is ItemVerticalViewHolder -> bindVerticalItems(holder, position)
        }
    }

    private fun bindHorizontalItems(holder: ItemHorizontalViewHolder, position: Int) {
        val currentItem = items[position].item as List<Recipe>
        val horizontalAdapter = HorizontalAdapter(currentItem)
        horizontalAdapter.setItems(currentItem)
        holder.binding.apply {
            horizontalRecyclerView.adapter = horizontalAdapter
        }
    }

    private fun bindVerticalItems(holder: ItemVerticalViewHolder, position: Int) {
        val currentItem = items[position].item as List<Recipe>
        val verticalAdapter = VerticalAdapter(currentItem)
        verticalAdapter.setItems(currentItem)
        holder.binding.apply {
            verticalRecyclerView.adapter = verticalAdapter
        }
    }

    abstract class BaseViewHolder(viewItem: View) : RecyclerView.ViewHolder(viewItem)

    class ItemPopularViewHolder(viewItem: View): BaseViewHolder(viewItem) {
        val binding = ItemPopularRecipeHeaderBinding.bind(viewItem)
    }

    class ItemHorizontalViewHolder(viewItem: View): BaseViewHolder(viewItem) {
        val binding = LayoutPopularRecipesBinding.bind(viewItem)
    }

    class ItemEditorChoiceViewHolder(viewItem: View) : BaseViewHolder(viewItem) {
        val binding = ItemEasyToCookHeaderBinding.bind(viewItem)
    }

    class ItemVerticalViewHolder(viewItem: View) : BaseViewHolder(viewItem) {
        val binding = LayoutEasyToCookRecipesBinding.bind(viewItem)
    }

    override fun getItemViewType(position: Int): Int {
        return when (items[position].type) {
            HomeItemType.ITEM_POPULAR -> ITEM_POPULAR
            HomeItemType.ITEM_HORIZONTAL -> ITEM_HORIZONTAL
            HomeItemType.ITEM_EDITOR_CHOICE -> ITEM_EDITOR_CHOICE
            HomeItemType.ITEM_VERTICAL -> ITEM_VERTICAL
        }
    }


    companion object {
        const val ITEM_POPULAR = 0
        const val ITEM_HORIZONTAL = 1
        const val ITEM_EDITOR_CHOICE = 2
        const val ITEM_VERTICAL = 3
    }
}
