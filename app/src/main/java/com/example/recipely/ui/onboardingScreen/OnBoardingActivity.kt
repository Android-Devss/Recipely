package com.example.recipely.ui.onboardingScreen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import android.view.View
import android.widget.TextView
import androidx.viewpager.widget.ViewPager
import com.example.recipely.R
import com.example.recipely.databinding.ActivityOnBoardingBinding
import com.example.recipely.ui.MainActivity

class OnBoardingActivity : AppCompatActivity() {
    private lateinit var binding:ActivityOnBoardingBinding
    private lateinit var viewPagerAdapter:ViewPagerAdapter
    private lateinit var dots: Array<TextView>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOnBoardingBinding.inflate(layoutInflater)
        setContentView(binding.root)
            binding.getStarted.setOnClickListener {
                if (getItem(0) > 0) {
                    binding.slideViewPager.setCurrentItem(getItem(-1), true)
                }
            }

           binding.next.setOnClickListener {
                if (getItem(0) < 2) {
                    binding.slideViewPager.setCurrentItem(getItem(1), true)
                    binding.skip.setTextColor(getColor(R.color.black87))
                    binding.next.setTextColor(getColor(R.color.black87))
                } else {
                    val intent = Intent(this@OnBoardingActivity, MainActivity::class.java)
                    startActivity(intent)
                    finish()
                }
            }

            binding.skip.setOnClickListener {
                val intent = Intent(this@OnBoardingActivity, MainActivity::class.java)
                startActivity(intent)
                finish()
            }



            viewPagerAdapter = ViewPagerAdapter(this)
        binding.slideViewPager.adapter = viewPagerAdapter

            setUpIndicator(0)
        binding.slideViewPager.addOnPageChangeListener(viewListener)
        }

        private fun setUpIndicator(position: Int) {
            dots = Array(3) { TextView(this) }
            binding.indicatorLayout.removeAllViews()

            for (i in dots.indices) {
                dots[i].text = Html.fromHtml("&#8226")
                dots[i].textSize = 35f
                dots[i].setTextColor(getColor(R.color.inactive))
                binding.indicatorLayout.addView(dots[i])
            }

            dots[position].setTextColor(getColor(R.color.active))
        }

        private val viewListener = object : ViewPager.OnPageChangeListener {
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
            }

            override fun onPageSelected(position: Int) {
                setUpIndicator(position)

                if (position > 0) {
                    binding.getStarted.visibility = View.VISIBLE
                } else {
                    binding.getStarted.visibility = View.INVISIBLE
                }
            }

            override fun onPageScrollStateChanged(state: Int) {
            }
        }

        private fun getItem(i: Int): Int {
            return binding.slideViewPager.currentItem + i
        }
    }