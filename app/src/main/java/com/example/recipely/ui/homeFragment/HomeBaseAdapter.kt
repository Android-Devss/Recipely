package com.example.recipely.ui.homeFragment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding


abstract class HomeBaseAdapter<T, VB : ViewBinding>(
    private var items: List<T>,
) : RecyclerView.Adapter<HomeBaseAdapter.BaseViewHolder<VB>>() {

    abstract val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> VB
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<VB> {
        val inflater = LayoutInflater.from(parent.context)
        val binding = bindingInflater(inflater, parent, false)
        return BaseViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BaseViewHolder<VB>, position: Int) {
        val currentItem = items[position]
        onBindViewHolder(holder, position, currentItem)
    }

    abstract fun onBindViewHolder(holder: BaseViewHolder<VB>, position: Int, currentItem: T)
    override fun getItemCount() = items.size

    class BaseViewHolder<VB : ViewBinding>(val binding: VB) : RecyclerView.ViewHolder(binding.root)
}