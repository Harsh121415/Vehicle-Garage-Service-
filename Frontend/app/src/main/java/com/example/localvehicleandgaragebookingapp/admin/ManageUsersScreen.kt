package com.example.localvehicleandgaragebookingapp.admin

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

data class User(val name: String, val email: String)

@Composable
fun ManageUsersScreen() {

    val users = listOf(
        User("Harsh", "harsh@gmail.com"),
        User("Admin", "admin@gmail.com"),
        User("User1", "user1@gmail.com")
    )

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {

        Text("Manage Users", style = MaterialTheme.typography.headlineMedium)

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn {
            items(users) { user ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                ) {
                    Column(modifier = Modifier.padding(12.dp)) {
                        Text("Name: ${user.name}")
                        Text("Email: ${user.email}")

                        Spacer(modifier = Modifier.height(8.dp))

                        Button(onClick = { }) {
                            Text("Delete User")
                        }
                    }
                }
            }
        }
    }
}