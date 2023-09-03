package com.example.recipely.ui.onboarding

import android.os.Bundle
import android.content.Intent
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.example.recipely.R
import com.example.recipely.databinding.ActivityMainBinding
import com.example.recipely.databinding.ActivityOnboardingBinding
import com.example.recipely.databinding.FragmentFirstScreenOnBoardingBinding
import com.example.recipely.databinding.FragmentSecondScreenOnBoardingBinding
import com.example.recipely.ui.MainActivity



class OnboardingActivity : FragmentActivity() {
    private lateinit var binding:ActivityOnboardingBinding
    private lateinit var onboardingManager: OnboardingManager
    private  var bindingFragment: FragmentFirstScreenOnBoardingBinding?= null
    private  var bindingFragment2: FragmentSecondScreenOnBoardingBinding?= null

    private var currentPage = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_onboarding)

        onboardingManager = OnboardingManager(this)

        if (onboardingManager.isOnboardingComplete()) {
            startMainActivity()
        } else {
            showOnboardingFragment(FirstScreenOnBoarding())
        }
//        if (currentPage == 0)
//        {
//            bindingFragment?.next?.setOnClickListener {
//                showOnboardingFragment(SecondScreenOnBoarding())
//            }
//
//            bindingFragment?.skip?.setOnClickListener {
//                startMainActivity()
//            }
//        }
//
//        else{
//            bindingFragment2?.next?.setOnClickListener {
//                showOnboardingFragment(FirstScreenOnBoarding())
//            }
//
//            bindingFragment2?.skip?.setOnClickListener {
//                startMainActivity()
//            }
//        }
       }

    fun startMainActivity() {
        onboardingManager.setOnboardingComplete()
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }

    fun showOnboardingFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, fragment)
            .commit()
    }
}
