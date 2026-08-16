package com.example.localvehicleandgaragebookingapp.admin

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

data class Booking(val user: String, val status: String)

@Composable
fun ManageBookingsScreen() {

    val bookings = listOf(
        Booking("Harsh", "Pending"),
        Booking("User1", "Accepted"),
        Booking("User2", "Completed")
    )

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {

        Text("Manage Bookings", style = MaterialTheme.typography.headlineMedium)

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn {
            items(bookings) { booking ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                ) {
                    Column(modifier = Modifier.padding(12.dp)) {
                        Text("User: ${booking.user}")
                        Text("Status: ${booking.status}")

                        Spacer(modifier = Modifier.height(8.dp))

                        Row {
                            Button(onClick = { }) {
                                Text("Accept")
                            }

                            Spacer(modifier = Modifier.width(8.dp))

                            Button(onClick = { }) {
                                Text("Reject")
                            }
                        }
                    }
                }
            }
        }
    }
}