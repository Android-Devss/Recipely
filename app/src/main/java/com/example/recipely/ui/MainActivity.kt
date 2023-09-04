package com.example.recipely.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.fragment.app.Fragment
import com.example.recipely.R
import com.example.recipely.databinding.ActivityMainBinding
import com.example.recipely.ui.advice.AdviceFragment
import com.example.recipely.ui.home.RecipeHomeFragment
import com.example.recipely.ui.recipecuisines.RecipeCuisinesFragment
import com.example.recipely.ui.search.SearchFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val recipeHomeFragment by lazy { RecipeHomeFragment() }
    private val adviceFragment by lazy { AdviceFragment() }
    private val recipeCuisinesFragment by lazy { RecipeCuisinesFragment() }
    private val searchFragment by lazy { SearchFragment() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initSubView()
        addNavigationListener()
    }

    private fun addNavigationListener() {
        binding.bottomNavigationBar.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_home -> {
                    replaceFragment(recipeHomeFragment)
                    true
                }

                R.id.navigation_search -> {
                    replaceFragment(searchFragment)
                    true
                }

                R.id.navigation_cuisine -> {
                    replaceFragment(recipeCuisinesFragment)
                    true
                }

                R.id.navigation_advice -> {
                    replaceFragment(adviceFragment)
                    true
                }

                else -> false
            }
        }
    }

    private fun initSubView() {
        addFragment(recipeHomeFragment)
    }

    private fun addFragment(fragment: Fragment) {
        if (!(fragment.isAdded))
            supportFragmentManager.beginTransaction()
                .add(R.id.fragment_container, fragment).addToBackStack(null)
                .commit()
    }

    private fun replaceFragment(fragment: Fragment) {
        if (!(fragment.isAdded))
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, fragment).addToBackStack(null)
                .commit()
    }
}