package com.example.recipely.ui.onboarding
import android.content.Context
import android.content.SharedPreferences

class OnboardingManager(context: Context) {
    private val sharedPreferences: SharedPreferences =
        context.getSharedPreferences("Onboarding", Context.MODE_PRIVATE)

    fun setOnboardingComplete() {
        sharedPreferences.edit().putBoolean("onboarding_complete", true).apply()
    }

    fun isOnboardingComplete(): Boolean {
        return sharedPreferences.getBoolean("onboarding_complete", false)
    }
}
