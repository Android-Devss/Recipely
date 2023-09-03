package com.example.recipely.ui.advice

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.recipely.data.source.model.Advice
import com.example.recipely.databinding.ItemCardAdviceBinding
import com.example.recipely.ui.base.BaseAdapter
import com.example.recipely.util.loadImageWithPlaceholderAndCrossFade

class AdviceAdapter(advices: List<Advice>) : BaseAdapter<Advice, ItemCardAdviceBinding>(advices) {
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> ItemCardAdviceBinding
        get() = ItemCardAdviceBinding::inflate

    override fun onBindViewHolder(
        holder: BaseViewHolder<ItemCardAdviceBinding>,
        position: Int,
        currentItem: Advice
    ) {
        holder.binding.apply {
            adviceImg.loadImageWithPlaceholderAndCrossFade(currentItem.imgUrl)
            adviceInstruction.text = currentItem.description
        }
    }
}