package com.example.recipely.ui.onboarding

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.recipely.R
import com.example.recipely.databinding.FragmentFirstScreenOnBoardingBinding
import com.example.recipely.ui.MainActivity
import com.example.recipely.util.replaceFragment


class FirstScreenOnBoarding : Fragment() {
    private var binding: FragmentFirstScreenOnBoardingBinding? = null

    // with the backing property of the kotlin we extract
    // the non null value of the _binding

    override fun onCreateView(

        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        // inflate the layout and bind to the _binding
    binding = FragmentFirstScreenOnBoardingBinding.inflate(inflater, container, false)
       binding?.next?.setOnClickListener{
           replaceFragment(SecondScreenOnBoarding())
         }
        binding?.skip?.setOnClickListener {
            activity?.let{
                val intent = Intent (it, MainActivity::class.java)
                it.startActivity(intent)
            }
        }
   return binding!!.root
}
}