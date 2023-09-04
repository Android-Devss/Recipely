package com.example.recipely.ui.onboardingScreen

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.example.recipely.R
import com.example.recipely.databinding.FragmentOnboardingBinding
import com.example.recipely.ui.home.RecipeHomeFragment
import com.example.recipely.util.SharedPreferencesUtil
import com.example.recipely.util.replaceFragment


class OnboardingFragment : Fragment() {
    private lateinit var viewPager: ViewPager
    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var binding:FragmentOnboardingBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        SharedPreferencesUtil.initPreferencesUtil(requireContext())
        binding = FragmentOnboardingBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.getStarted.setOnClickListener {


            replaceFragment(RecipeHomeFragment())
        }
        viewPager = view.findViewById(R.id.slideViewPager)
        val layouts = listOf(
            R.layout.slider_layout_first,
            R.layout.slider_layout_second
        )

        val adapter = OnboardingPagerAdapter(layouts, requireContext())
        viewPager.adapter = adapter

        sharedPreferences = requireContext().getSharedPreferences("onboarding_prefs", Context.MODE_PRIVATE)

        if (sharedPreferences.getBoolean("onboarding_completed", false)) {
            replaceFragment(RecipeHomeFragment())

        }

        val currentItem = viewPager.currentItem

        if (currentItem == 0) {
            binding.skip.setOnClickListener {
                replaceFragment(RecipeHomeFragment())

            }
            binding.next.setOnClickListener {
                viewPager.currentItem = currentItem + 1
                binding.skip.setTextColor(requireContext().getColor(R.color.black87))
                binding.next.setTextColor(requireContext().getColor(R.color.black87))
            }

        } else {
            binding.skip.setTextColor(requireContext().getColor(R.color.black87))
            binding.next.setTextColor(requireContext().getColor(R.color.black87))
            binding.skip.setOnClickListener {

                replaceFragment(RecipeHomeFragment())
            }
            binding.next.setOnClickListener {

                replaceFragment(RecipeHomeFragment())
            }
            with(sharedPreferences.edit()) {
                putBoolean("onboarding_completed", true)
                apply()
            }
            replaceFragment(RecipeHomeFragment())
        }
    }


}
