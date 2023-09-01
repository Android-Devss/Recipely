package com.example.recipely.ui.recipehome

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.recipely.R
import com.example.recipely.data.source.model.Recipe
import com.example.recipely.databinding.ItemEditorChoiceBinding
import com.example.recipely.databinding.ItemHorizontalRecipesBinding
import com.example.recipely.databinding.ItemPopularRecipesBinding
import com.example.recipely.databinding.ItemVerticalRecipesBinding
import com.example.recipely.ui.recipehome.homemodel.HomeItem

class HomeAdapter(private var items: List<HomeItem<Any>>):
    RecyclerView.Adapter<HomeAdapter.BaseViewHolder>() {
    private lateinit var item : List<Recipe>

    override fun onCreateViewHolder(parent: ViewGroup, viewType : Int) : BaseViewHolder {
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

            else -> throw Exception(" UNKNOWN VIEW TYPE")

        }
        return super.createViewHolder(parent, viewType)
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: BaseViewHolder, position : Int) {
        when (holder) {
            is ItemPopularViewHolder -> {
                holder.binding.apply {
                    popularRecipesViewAll.setOnClickListener {
                    }
                }
            }
            is ItemEditorChoiceViewHolder -> {
                holder.binding.apply {
                    editorChoiceViewAll.setOnClickListener {
                    }
                }
            }
            is ItemHorizontalViewHolder -> bindHorizontalItems(holder, position)
            is ItemVerticalViewHolder -> bindVerticalItems(holder, position)
        }
    }
    private fun bindHorizontalItems(holder: ItemHorizontalViewHolder, position : Int) {
        val currentItem = items[position].item as List<Recipe>
        val horizontalAdapter = HorizontalAdapter(item)
        horizontalAdapter.setItems(currentItem)
        holder.binding.apply {
            horizontalRecyclerView.adapter = horizontalAdapter
        }
    }

    private fun bindVerticalItems(holder: ItemVerticalViewHolder, position : Int) {
        val currentItem = items[position].item as Recipe
        holder.binding.apply {
            verticalRecipeImage.load(currentItem.imageUrl){
            crossfade(true)
            placeholder(R.drawable.recipe_image_placeholder)
            error(R.drawable.recipe_image_error)}
            verticalRecipeCuisine.text = currentItem.cuisine
            verticalRecipeName.text = currentItem.recipeName
        }
    }

    abstract class BaseViewHolder(viewItem: View): RecyclerView.ViewHolder(viewItem)

    class ItemPopularViewHolder(viewItem: View): BaseViewHolder(viewItem) {
        val binding = ItemPopularRecipesBinding.bind(viewItem)
    }

    class ItemHorizontalViewHolder(viewItem: View): BaseViewHolder(viewItem) {
        val binding = ItemHorizontalRecipesBinding.bind(viewItem)
    }

    class ItemEditorChoiceViewHolder(viewItem: View): BaseViewHolder(viewItem) {
        val binding = ItemEditorChoiceBinding.bind(viewItem)
    }

    class ItemVerticalViewHolder(viewItem: View): BaseViewHolder(viewItem) {
        val binding = ItemVerticalRecipesBinding.bind(viewItem)
    }


    companion object {
        const val ITEM_POPULAR= 0
        const val ITEM_HORIZONTAL= 1
        const val ITEM_EDITOR_CHOICE= 2
        const val ITEM_VERTICAL =3
    }
}
