package com.example.localvehicleandgaragebookingapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.localvehicleandgaragebookingapp.auth.LoginScreen
import com.example.localvehicleandgaragebookingapp.auth.RegisterScreen
import com.example.localvehicleandgaragebookingapp.admin.AdminDashboardActivity
import com.example.localvehicleandgaragebookingapp.dashboard.DashBoardActivity
import android.content.Intent
import androidx.compose.ui.platform.LocalContext
import com.example.localvehicleandgaragebookingapp.viewmodel.LoginViewModel

@Composable
fun AppNavGraph(navController: NavHostController, loginViewModel: LoginViewModel) {
    val context = LocalContext.current

    NavHost(
        navController = navController,
        startDestination = "login"
    ) {
        composable("login") {
            LoginScreen(navController = navController, viewModel = loginViewModel)
        }

        composable("register") {
            RegisterScreen(navController = navController)
        }

        composable("admin_dashboard") {
            context.startActivity(Intent(context, AdminDashboardActivity::class.java))
        }

        composable("list") {
            context.startActivity(Intent(context, DashBoardActivity::class.java))
        }
    }
}
