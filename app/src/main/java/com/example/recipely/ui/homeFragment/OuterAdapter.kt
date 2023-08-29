package com.example.recipely.ui.homeFragment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recipely.R
import com.example.recipely.data.source.model.Recipe
import com.example.recipely.databinding.ParentRecyclerviewLayoutBinding
import com.example.recipely.domain.DataManager

class OuterAdapter(private var list : List<Recipe>) :
    RecyclerView.Adapter<OuterAdapter.OuterViewHolder>() {


    override fun onCreateViewHolder(parent : ViewGroup, viewType : Int) : OuterViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.parent_recyclerview_layout,
            parent,
            false
        )
        return OuterViewHolder(view)
    }

    override fun getItemCount() = list.size
    override fun onBindViewHolder(holder : OuterViewHolder, position : Int) {
        val innerAdapter = InnerAdapter(DataManager.recipes)
        holder.binding.apply {

            recyclerviewChild.layoutManager = LinearLayoutManager(
                recyclerviewChild.context,
                LinearLayoutManager.HORIZONTAL,
                false
            )
            recyclerviewChild.adapter = innerAdapter
        }

    }

    class OuterViewHolder(viewItem : View) : RecyclerView.ViewHolder(viewItem) {
        val binding = ParentRecyclerviewLayoutBinding.bind(viewItem)

    }


}