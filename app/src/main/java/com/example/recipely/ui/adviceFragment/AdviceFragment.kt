package com.example.recipely.ui.adviceFragment

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.recipely.data.source.DataSourceImp
import com.example.recipely.databinding.AdviceFragmentBinding
import com.example.recipely.ui.base.BaseFragment
import com.example.recipely.util.CsvParser

class AdviceFragment : BaseFragment<AdviceFragmentBinding>() {
    private val dataSource by lazy { DataSourceImp(requireContext(), CsvParser()) }
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> AdviceFragmentBinding
        get() = AdviceFragmentBinding::inflate
    override val logTag: String
        get() = this::class.java.simpleName

    override fun initialize() {}

    override fun addCallbacks() {
        val adviceAdapter = AdviceAdapter(dataSource.getAdvices())
        binding?.recyclerAdviceList?.adapter = adviceAdapter
    }
}