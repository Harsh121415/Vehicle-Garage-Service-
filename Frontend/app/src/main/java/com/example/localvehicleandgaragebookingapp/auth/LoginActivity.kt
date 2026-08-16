package com.example.localvehicleandgaragebookingapp.auth

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.example.localvehicleandgaragebookingapp.navigation.AppNavGraph
import com.example.localvehicleandgaragebookingapp.viewmodel.LoginViewModel

class LoginActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        super.onCreate(savedInstanceState)

        setContent {
            val navController = rememberNavController()

            // ✅ ViewModel attach
            val viewModel: LoginViewModel = viewModel()

            // Pass ViewModel to NavGraph
            AppNavGraph(
                navController = navController,
                loginViewModel = viewModel
            )
        }
    }
}