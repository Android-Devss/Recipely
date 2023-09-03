package com.example.recipely.ui.adviceFragment

import android.view.LayoutInflater
import android.view.ViewGroup
import coil.load
import com.example.recipely.R
import com.example.recipely.data.source.model.Advice
import com.example.recipely.databinding.ItemCardAdviceBinding
import com.example.recipely.ui.base.BaseAdapter

class AdviceAdapter(advices: List<Advice>) : BaseAdapter<Advice, ItemCardAdviceBinding>(advices) {
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> ItemCardAdviceBinding
        get() = ItemCardAdviceBinding::inflate

    override fun onBindViewHolder(
        holder: BaseViewHolder<ItemCardAdviceBinding>,
        position: Int,
        currentItem: Advice
    ) {
        holder.binding.apply {
            adviceImg.load(currentItem.imgUrl) {
                crossfade(true)
                placeholder(R.drawable.ic_loading)
            }
            adviceInstruction.text = currentItem.description
        }
    }
}