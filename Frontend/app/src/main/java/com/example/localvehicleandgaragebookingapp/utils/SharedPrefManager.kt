package com.example.localvehicleandgaragebookingapp.utils

import android.content.Context
import android.content.SharedPreferences

object SharedPrefManager {
    private const val SHARED_PREF_NAME = "my_shared_pref"

    fun clearUser(context: Context) {
        val sharedPreferences: SharedPreferences = context.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.clear()
        editor.apply()
    }
}
