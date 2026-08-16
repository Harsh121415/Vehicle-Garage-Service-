package com.example.localvehicleandgaragebookingapp.utils

import android.content.Context
import android.content.SharedPreferences

object PrefsHelper {
    private const val PREFS_NAME = "app_prefs"
    private const val KEY_TOKEN = "auth_token"
    private const val KEY_USER_NAME = "user_name"
    private const val KEY_USER_EMAIL = "user_email"

    private fun getPrefs(context: Context): SharedPreferences {
        return context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
    }

    fun saveToken(context: Context, token: String) {
        getPrefs(context).edit().putString(KEY_TOKEN, token).apply()
    }

    fun saveUserData(context: Context, name: String, email: String) {
        getPrefs(context).edit().apply {
            putString(KEY_USER_NAME, name)
            putString(KEY_USER_EMAIL, email)
        }.apply()
    }

    fun getToken(context: Context): String? {
        return getPrefs(context).getString(KEY_TOKEN, null)
    }
}
