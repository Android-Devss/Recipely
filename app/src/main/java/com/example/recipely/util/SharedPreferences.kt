package com.example.recipely.util

import android.content.Context

import android.content.SharedPreferences

object SharedPreferencesUtil {
    private var sharedPreferences: SharedPreferences? = null
    private const val SHARED_PREFERENCES_NAME = "Recipe"


    fun initPreferencesUtil(context: Context) {
        sharedPreferences = context.getSharedPreferences(
            SHARED_PREFERENCES_NAME,
            Context.MODE_PRIVATE
        )
    }
}