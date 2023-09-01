package com.example.recipely.ui

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.recipely.R
import com.example.recipely.databinding.ActivityMainBinding
import com.example.recipely.ui.advice.AdviceFragment
import com.example.recipely.ui.fragment.search.SearchFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val searchFragment=SearchFragment()
    private val adviceFragment=AdviceFragment()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
    private fun addFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.fragmentContainerView, fragment)
        transaction.commit()
    }
    fun on(view: View) {
        addFragment(searchFragment)
    }

    fun onClick(view: View) {
        addFragment(adviceFragment)
    }

}