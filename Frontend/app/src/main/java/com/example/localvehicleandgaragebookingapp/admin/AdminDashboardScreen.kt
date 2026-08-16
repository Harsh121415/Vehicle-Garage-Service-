package com.example.localvehicleandgaragebookingapp.admin

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun AdminDashboardScreen() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("Admin Panel", fontSize = 24.sp)

        Spacer(modifier = Modifier.height(20.dp))

        Button(onClick = {}) {
            Text("Manage Users")
        }

        Button(onClick = {}) {
            Text("Manage Bookings")
        }

        Button(onClick = {}) {
            Text("Manage Complaints")
        }
    }
}