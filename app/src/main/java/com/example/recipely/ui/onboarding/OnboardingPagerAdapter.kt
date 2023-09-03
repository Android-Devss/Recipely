package com.example.recipely.ui.onboarding



import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter


@Suppress("DEPRECATION")
class ViewPagerAdapter(fragment: FragmentManager) : FragmentPagerAdapter(fragment) {

    private val fragments = listOf(
        FirstScreenOnBoarding(),
        SecondScreenOnBoarding()
    )

    override fun getCount(): Int {
        return 2
    }

    override fun getItem(position: Int): Fragment {
        return fragments[position]
    }
}