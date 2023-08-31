package com.example.recipely.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.recipely.R
import com.example.recipely.databinding.ActivityMainBinding
import com.example.recipely.ui.recipedetails.RecipeDetailsFragment
import com.example.recipely.ui.recipehome.RecipeHomeFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        showHomeFragment()
//        showRecipeDetailsFragment(500)
    }

    private fun showRecipeDetailsFragment(recipeId: Int) {
        val recipeDetailsFragment = RecipeDetailsFragment.newInstance(recipeId)
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, recipeDetailsFragment)
            .commit()
    }
    private fun showHomeFragment() {
        val homeFragment = RecipeHomeFragment()
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container,homeFragment )
            .commit()
    }
}