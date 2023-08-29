package com.example.recipely.ui.homeFragment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.net.toUri
import androidx.recyclerview.widget.RecyclerView
import com.example.recipely.R
import com.example.recipely.data.source.model.Recipe
import com.example.recipely.databinding.HomeEditorsCardBinding
import com.example.recipely.databinding.HomePopularCardBinding


class InnerAdapter(private var list : List<Recipe>) :
    RecyclerView.Adapter<InnerAdapter.BaseViewHolder>() {
    private val innerItems : List<Recipe> = list.take(10)

    override fun onCreateViewHolder(parent : ViewGroup, viewType : Int) : BaseViewHolder {
        when (viewType) {
            POPULAR_RECIPE -> {
                val view = LayoutInflater.from(parent.context).inflate(
                    R.layout.home_popular_card,
                    parent,
                    false
                )
                return PopularRcipesViewHolder(view)
            }

            EDITORS_CHOISE -> {
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

    override fun getItemCount() = innerItems.size

    override fun onBindViewHolder(holder : BaseViewHolder, position : Int) {
        val currentItem = list[position + 1]
        val uri = currentItem.url.toUri()
        when (holder) {

            is PopularRcipesViewHolder -> {
                holder.binding.apply {
                    recipeName.text= currentItem.recipeName
                    recipeImage.setImageURI(uri)
                }
            }

            is EditorsViewHolder -> {
                holder.binding.apply {
                   recipeImage.setImageURI(uri)
                    recipeName.text = currentItem.recipeName
                    chefName.text=R.string.chef_name.toString()
                    iconArrow.setImageResource(R.drawable.baseline_arrow_forward_24)
                }
            }

        }
    }

    override fun getItemViewType(position : Int) : Int {
        return when (position) {
            0 -> {
                EDITORS_CHOISE
            }

            1 -> {
                POPULAR_RECIPE
            }


            else -> 0
        }
    }

    abstract class BaseViewHolder(viewItem : View) : RecyclerView.ViewHolder(viewItem)

    class PopularRcipesViewHolder(viewItem : View) : BaseViewHolder(viewItem) {
        val binding = HomePopularCardBinding.bind(viewItem)
    }

    class EditorsViewHolder(viewItem : View) : BaseViewHolder(viewItem) {
        val binding = HomeEditorsCardBinding.bind(viewItem)
    }


    companion object {
        const val POPULAR_RECIPE = 0
        const val EDITORS_CHOISE = 1
        

    }

}