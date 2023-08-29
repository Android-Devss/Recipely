package com.example.recipely.ui.homeFragment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recipely.databinding.FragmentHomeBinding
import com.example.recipely.ui.base.BaseFragment
class HomeFragment : BaseFragment<FragmentHomeBinding>() {

    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentHomeBinding =
        FragmentHomeBinding::inflate

    override val logTag: String = "RecipeFragment"

    override fun initialize() {



    }

    override fun addCallbacks() {
    }
}

