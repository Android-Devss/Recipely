package com.example.recipely.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.recipely.R
import com.example.recipely.data.source.DataSourceImp
import com.example.recipely.databinding.ActivityMainBinding
import com.example.recipely.util.CsvParser

class MainActivity: AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var dataSource: DataSourceImp

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        dataSource = DataSourceImp(this, CsvParser())
        showRecipeDetailsFragment()
    }
    private fun showRecipeDetailsFragment() {
        val recipeDetailsFragment = RecipeDetailsFragment()
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, recipeDetailsFragment)
            .commit()
    }

}