package com.example.recipely.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.recipely.R
import com.example.recipely.data.source.model.Recipe
import com.example.recipely.databinding.HorizontalCardHomeBinding
import com.example.recipely.databinding.ItemEditorChoiceBinding
import com.example.recipely.databinding.ItemHorizontalRecipesBinding
import com.example.recipely.databinding.ItemPopularRecipesBinding
import com.example.recipely.databinding.ItemVerticalRecipesBinding
import com.example.recipely.ui.base.BaseAdapter

class HomeAdapter(private var items : List<Recipe>) :
    RecyclerView.Adapter<HomeAdapter.BaseViewHolder>() {
    private lateinit var binding : HorizontalCardHomeBinding
    private lateinit var item : Recipe

    override fun onCreateViewHolder(parent : ViewGroup, viewType : Int) : BaseViewHolder {
        when (viewType) {
            ITEM_POPULAR -> {
                val view = LayoutInflater.from(parent.context).inflate(
                    R.layout.item_popular_recipes,
                    parent,
                    false
                )
                ItemPopularViewHolder(view)
            }

            ITEM_HORIZONTAL -> {
                val view = LayoutInflater.from(parent.context).inflate(
                    R.layout.item_horizontal_recipes,
                    parent,
                    false
                )
                ItemHorizontalViewHolder(view)
            }

            ITEM_EDITOR_CHOICE -> {
                val view = LayoutInflater.from(parent.context).inflate(
                    R.layout.item_editor_choice,
                    parent,
                    false
                )
                ItemEditorChoiceViewHolder(view)
            }

            ITEM_VERTICAL -> {
                val view = LayoutInflater.from(parent.context).inflate(
                    R.layout.item_vertical_recipes,
                    parent,
                    false
                )
                ItemVerticalViewHolder(view)
            }
        }
        return super.createViewHolder(parent, viewType)
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder : BaseViewHolder, position : Int) {
        when (holder) {
            is ItemPopularViewHolder -> {
                holder.binding.apply {
                    popularRecipesViewAll.setOnClickListener {
                    }
                }
            }

            is ItemHorizontalViewHolder -> {
                holder.binding.apply {
                    bindHorizontalItems(holder, position)
                }

            }

            is ItemEditorChoiceViewHolder -> {
                holder.binding.apply {
                    editorChoiceViewAll.setOnClickListener {
                    }
                }
            }

            is ItemVerticalViewHolder -> {
                holder.binding.apply {
                    bindVerticalItems(holder, position)
                }
            }
        }
    }

    private fun bindHorizontalItems(holder : ItemHorizontalViewHolder,  position : Int) {
        val currentItem = items[position]
        with(binding) {
            horizontalRecipeNameHome.text = currentItem.recipeName
            binding.horizontalRecipeImageHome.load(currentItem.imageUrl)
            root.setOnClickListener {
            }
        }
    }
    private fun bindVerticalItems(holder : ItemVerticalViewHolder, position : Int) {
        val currentItem = items[position]
        holder.binding.apply {
            verticalRecipeImage.load(currentItem.imageUrl)
            verticalRecipeCuisine.text = currentItem.cuisine
            verticalRecipeName.text = currentItem.recipeName
        }
    }
    override fun getItemViewType(position : Int) : Int {
        when (position) {
            0 -> {
                return ITEM_POPULAR
            }

            1 -> {
                return ITEM_HORIZONTAL
            }

            2 -> {
                return ITEM_EDITOR_CHOICE
            }

            3 -> {
                return ITEM_VERTICAL
            }
            else -> return 0
        }
    }

    abstract class BaseViewHolder(viewItem : View) : RecyclerView.ViewHolder(viewItem)

    class ItemPopularViewHolder(viewItem : View) : BaseViewHolder(viewItem) {
        val binding = ItemPopularRecipesBinding.bind(viewItem)
    }

    class ItemHorizontalViewHolder(viewItem : View) : BaseViewHolder(viewItem) {
        val binding = ItemHorizontalRecipesBinding.bind(viewItem)
    }

    class ItemEditorChoiceViewHolder(viewItem : View) : BaseViewHolder(viewItem) {
        val binding = ItemEditorChoiceBinding.bind(viewItem)
    }

    class ItemVerticalViewHolder(viewItem : View) : BaseViewHolder(viewItem) {
        val binding = ItemVerticalRecipesBinding.bind(viewItem)
    }


    companion object {
        const val ITEM_POPULAR = 0
        const val ITEM_HORIZONTAL = 1
        const val ITEM_EDITOR_CHOICE = 2
        const val ITEM_VERTICAL = 3
    }

}

