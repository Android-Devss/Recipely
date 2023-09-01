package com.example.recipely.ui.fragment.search

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.recipely.R
import com.example.recipely.data.source.model.Recipe
import com.example.recipely.databinding.ItemSearchCardBinding

class SearchAdapter(
    private val listener: RecipeInteractionListener
) : RecyclerView.Adapter<SearchAdapter.SearchViewHolder>() {

    private var recipes = arrayListOf<Recipe>()
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): SearchViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_search_card, parent, false)
        return SearchViewHolder(view)
    }

    fun setData(newRecipesList: List<Recipe>) {
        val diffCallback = RecipeDiffUtil(recipes, newRecipesList)
        val diffResult = DiffUtil.calculateDiff(diffCallback)
        recipes = newRecipesList as ArrayList<Recipe>
        diffResult.dispatchUpdatesTo(this)
    }

    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {
        val currentRecipe = recipes[position]
        holder.binding.apply {
            tvRecipeName.text = currentRecipe.recipeName
            tvRecipeCuisine.text = currentRecipe.cuisine
            ivRecipeImage.load(currentRecipe.imageUrl) {
                placeholder(R.drawable.ic_loading)
            }
            root.setOnClickListener { listener.onClickRecipe(currentRecipe.id) }
        }

    }

    override fun getItemCount() = recipes.size

    class SearchViewHolder(viewItem: View) : RecyclerView.ViewHolder(viewItem) {
        val binding = ItemSearchCardBinding.bind(itemView)
    }

    interface RecipeInteractionListener {
        fun onClickRecipe(recipeId: Int)
    }

}