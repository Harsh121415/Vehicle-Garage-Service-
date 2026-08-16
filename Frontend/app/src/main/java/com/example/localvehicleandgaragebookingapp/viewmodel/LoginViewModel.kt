package com.example.localvehicleandgaragebookingapp.viewmodel

import com.example.localvehicleandgaragebookingapp.data.model.LoginRequest
import android.app.Application
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.localvehicleandgaragebookingapp.network.RetrofitClient
import com.example.localvehicleandgaragebookingapp.utils.PrefsHelper
import kotlinx.coroutines.launch

class LoginViewModel(application: Application) : AndroidViewModel(application) {

    fun login(email: String, password: String, onResult: (Boolean) -> Unit) {
        // Use the standard public API for login
        val api = RetrofitClient.api

        viewModelScope.launch {
            try {
                val response = api.login(LoginRequest(email, password))

                if (response.isSuccessful && response.body() != null) {
                    val loginResponse = response.body()!!
                    val token = loginResponse.token

                    // 💾 SAVE TOKEN and USER DATA using PrefsHelper
                    PrefsHelper.saveToken(getApplication(), token)
                    PrefsHelper.saveUserData(
                        getApplication(),
                        loginResponse.user.name,
                        loginResponse.user.email
                    )

                    Toast.makeText(
                        getApplication(),
                        "Login Successful",
                        Toast.LENGTH_SHORT
                    ).show()
                    
                    onResult(true)

                } else {
                    Toast.makeText(
                        getApplication(),
                        "Invalid Credentials",
                        Toast.LENGTH_SHORT
                    ).show()
                    onResult(false)
                }

            } catch (e: Exception) {
                Toast.makeText(
                    getApplication(),
                    "Error: ${e.message}",
                    Toast.LENGTH_SHORT
                ).show()
                onResult(false)
            }
        }
    }
}
