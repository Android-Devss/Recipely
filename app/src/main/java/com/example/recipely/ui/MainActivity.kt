package com.example.recipely.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.recipely.data.repository.Recipe
import com.example.recipely.data.source.DataSourceImp
import com.example.recipely.databinding.ActivityMainBinding
import com.example.recipely.data.source.util.CsvParser

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private lateinit var parser : CsvParser
    private lateinit var dataSource : DataSourceImp
    private lateinit var recipe : Recipe

    override fun onCreate(savedInstanceState : Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        parser = CsvParser()
        dataSource = DataSourceImp(this, parser)
        recipe = dataSource.getAllRecipes().first()

        bindRecipe()

    }

    private fun bindRecipe() {
        binding.apply {
            Cuisine.text = recipe.cuisine
            TotalTimeInMins.text = recipe.totalTimeInMinutes.toString()
            IngredientCount.text = recipe.ingredientsCount.toString()
        }
    }
}