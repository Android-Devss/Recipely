package com.example.recipely.ui.advice

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.recipely.data.repository.RepositoryImp
import com.example.recipely.data.source.DataSourceImp
import com.example.recipely.databinding.AdviceFragmentBinding
import com.example.recipely.domain.Repository
import com.example.recipely.ui.base.BaseFragment
import com.example.recipely.util.CsvParser

class AdviceFragment : BaseFragment<AdviceFragmentBinding>() {
    private val dataSource by lazy { DataSourceImp(requireContext(), CsvParser()) }
    private val dataManager: Repository by lazy { RepositoryImp(dataSource) }
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> AdviceFragmentBinding
        get() = AdviceFragmentBinding::inflate
    override val logTag: String
        get() = this::class.java.simpleName

    override fun initialize() {}

    override fun addCallbacks() {
        val adviceAdapter = AdviceAdapter(dataManager.getAdvices())
        binding?.recyclerAdviceList?.adapter = adviceAdapter
    }
}