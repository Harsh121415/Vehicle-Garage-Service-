package com.example.localvehicleandgaragebookingapp.admin

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

data class Complaint(val description: String, val status: String)

@Composable
fun ManageComplaintsScreen() {

    val complaints = listOf(
        Complaint("Engine issue", "Open"),
        Complaint("Brake problem", "In Progress"),
        Complaint("Oil leakage", "Resolved")
    )

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {

        Text("Manage Complaints", style = MaterialTheme.typography.headlineMedium)

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn {
            items(complaints) { complaint ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                ) {
                    Column(modifier = Modifier.padding(12.dp)) {
                        Text("Issue: ${complaint.description}")
                        Text("Status: ${complaint.status}")

                        Spacer(modifier = Modifier.height(8.dp))

                        Button(onClick = { }) {
                            Text("Mark Resolved")
                        }
                    }
                }
            }
        }
    }
}