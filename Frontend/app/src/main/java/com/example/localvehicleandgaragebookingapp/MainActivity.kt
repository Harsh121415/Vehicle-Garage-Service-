package com.example.localvehicleandgaragebookingapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.example.localvehicleandgaragebookingapp.navigation.AppNavGraph
import com.example.localvehicleandgaragebookingapp.ui.theme.LocalVehicleAndGarageBookingAppTheme
import com.example.localvehicleandgaragebookingapp.utils.CloudinaryManager
import com.example.localvehicleandgaragebookingapp.viewmodel.LoginViewModel

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        // Initialize Cloudinary
        CloudinaryManager.init(this)

        setContent {
            LocalVehicleAndGarageBookingAppTheme {
                val navController = rememberNavController()
                val loginViewModel: LoginViewModel = viewModel()

                // ✅ Fixed: Added required loginViewModel parameter
                AppNavGraph(
                    navController = navController,
                    loginViewModel = loginViewModel
                )
            }
        }
    }
}
