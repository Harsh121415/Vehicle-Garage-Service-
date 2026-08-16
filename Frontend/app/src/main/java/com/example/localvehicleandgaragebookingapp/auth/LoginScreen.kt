package com.example.localvehicleandgaragebookingapp.auth

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.localvehicleandgaragebookingapp.data.model.LoginRequest
import com.example.localvehicleandgaragebookingapp.data.model.LoginResponse
import com.example.localvehicleandgaragebookingapp.network.RetrofitClient
import com.example.localvehicleandgaragebookingapp.utils.PrefsHelper
import com.example.localvehicleandgaragebookingapp.viewmodel.LoginViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@Composable
fun LoginScreen(navController: NavHostController, viewModel: LoginViewModel) {

    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }
    var forgotpass by remember { mutableStateOf(false) }
    var isLoading by remember { mutableStateOf(false) }

    val context = LocalContext.current
    val primaryColor = MaterialTheme.colorScheme.primary

    Box(
        modifier = Modifier
            .fillMaxSize()
            .systemBarsPadding()
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {

        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(16.dp),
            elevation = CardDefaults.cardElevation(6.dp)
        ) {

            Column(
                modifier = Modifier.padding(20.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Text(
                    text = "ServX",
                    style = MaterialTheme.typography.headlineSmall,
                    color = primaryColor
                )

                Text(
                    text = "Vehicle Service & Garage Booking",
                    fontSize = 13.sp
                )

                Spacer(modifier = Modifier.height(24.dp))

                OutlinedTextField(
                    value = email,
                    onValueChange = { email = it },
                    label = { Text("Email") },
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(14.dp))

                OutlinedTextField(
                    value = password,
                    onValueChange = { password = it },
                    label = { Text("Password") },
                    singleLine = true,
                    visualTransformation = if (passwordVisible) VisualTransformation.None
                    else PasswordVisualTransformation(),
                    trailingIcon = {
                        Text(
                            text = if (passwordVisible) "Hide" else "Show",
                            fontSize = 13.sp,
                            modifier = Modifier.clickable {
                                passwordVisible = !passwordVisible
                            }
                        )
                    },
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = "Forgot Password?",
                    fontSize = 13.sp,
                    color = primaryColor,
                    modifier = Modifier
                        .align(Alignment.End)
                        .clickable { forgotpass = true }
                )

                Spacer(modifier = Modifier.height(24.dp))

                if (isLoading) {
                    CircularProgressIndicator()
                } else {

                    Button(
                        onClick = {

                            if (email.isEmpty() || password.isEmpty()) {
                                Toast.makeText(context, "Enter email & password", Toast.LENGTH_SHORT).show()
                                return@Button
                            }


                            if (email == "admin@gmail.com" && password == "admin123") {
                                Toast.makeText(context, "Admin Login Successful", Toast.LENGTH_SHORT).show()

                                navController.navigate("admin_dashboard") {
                                    popUpTo("login") { inclusive = true }
                                }
                                return@Button
                            }


                            isLoading = true

                            // Using viewModel for login logic
                            viewModel.login(email, password) { success ->
                                isLoading = false
                                if (success) {
                                    navController.navigate("list") {
                                        popUpTo("login") { inclusive = true }
                                    }
                                }
                            }
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(48.dp),
                        shape = RoundedCornerShape(10.dp)
                    ) {
                        Text("Login")
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = "Don't have an account? Register",
                    fontSize = 13.sp,
                    color = primaryColor,
                    modifier = Modifier.clickable {
                        navController.navigate("register")
                    }
                )
            }
        }
    }

    if (forgotpass) {
        AlertDialog(
            onDismissRequest = { forgotpass = false },
            title = { Text("Forgot Password") },
            text = { Text("Feature coming soon") },
            confirmButton = {
                TextButton(onClick = { forgotpass = false }) {
                    Text("OK")
                }
            }
        )
    }
}
