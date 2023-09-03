package com.example.recipely.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.fragment.app.Fragment
import com.example.recipely.R
import com.example.recipely.databinding.ActivityMainBinding
import com.example.recipely.ui.recipecuisines.RecipeCuisinesFragment
import com.example.recipely.ui.recipecuisines.cuisinesdetails.RecipeCuisinesDetailsFragment
import com.example.recipely.ui.recipehome.RecipeHomeFragment
import com.example.recipely.ui.seeAllHome.SeeAllFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val recipeHomeFragment by lazy { RecipeHomeFragment() }
    private val recipeCuisinesFragment by lazy { RecipeCuisinesFragment() }
    private val recipeCuisinesDetailsFragment by lazy { RecipeCuisinesDetailsFragment() }
    private val seeAllFragment by lazy { SeeAllFragment() }

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
                    replaceFragment(seeAllFragment)
                    true
                }

                R.id.navigation_cuisine -> {
                    replaceFragment(recipeCuisinesFragment)
                    true
                }

                R.id.navigation_advice -> {
                    replaceFragment(recipeCuisinesDetailsFragment)
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
        supportFragmentManager.beginTransaction()
            .add(R.id.fragment_container, fragment)
            .commit()
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }
}