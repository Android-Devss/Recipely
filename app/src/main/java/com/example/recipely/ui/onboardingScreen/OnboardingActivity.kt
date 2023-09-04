package com.example.recipely.ui.onboardingScreen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import com.example.recipely.R
import com.example.recipely.ui.MainActivity
import android.content.Context
import android.content.SharedPreferences
import com.example.recipely.databinding.ActivityOnBoardingBinding

class OnboardingActivity : AppCompatActivity() {
    private lateinit var viewPager: ViewPager
    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var binding: ActivityOnBoardingBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOnBoardingBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar!!.hide()
        binding.getStarted.setOnClickListener {
            goToMainActivity()
        }
        viewPager = findViewById(R.id.slideViewPager)
        val layouts = listOf(
            R.layout.slider_layout_first,
            R.layout.slider_layout_second
        )

        val adapter = OnboardingPagerAdapter(layouts, this)
        viewPager.adapter = adapter

        sharedPreferences = getSharedPreferences("onboarding_prefs", Context.MODE_PRIVATE)

        if (sharedPreferences.getBoolean("onboarding_completed", false)) {
            goToMainActivity()
        }


        val currentItem = viewPager.currentItem

        if (currentItem == 0) {
            binding.skip.setOnClickListener {
                goToMainActivity()
            }
            binding.next.setOnClickListener {
                viewPager.currentItem = currentItem + 1
                binding.skip.setTextColor(getColor(R.color.black87))
                binding.next.setTextColor(getColor(R.color.black87))
            }

        } else {
            binding.skip.setTextColor(getColor(R.color.black87))
            binding.next.setTextColor(getColor(R.color.black87))
            binding.skip.setOnClickListener {
                goToMainActivity()
            }
            binding.next.setOnClickListener {
                goToMainActivity()

            }
            with(sharedPreferences.edit()) {
                putBoolean("onboarding_completed", true)
                apply()
            }
            goToMainActivity()
        }
    }


    private fun goToMainActivity() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}
