package com.example.localvehicleandgaragebookingapp.complaint

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.localvehicleandgaragebookingapp.viewmodel.ComplaintViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.runtime.collectAsState
import com.example.localvehicleandgaragebookingapp.data.model.Complaint

class ComplaintListActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComplaintListScreen()
        }
    }
}

@Composable
fun ComplaintListScreen() {
    val viewModel: ComplaintViewModel = viewModel()
    val complaintList = viewModel.complaints.collectAsState().value

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "My Complaints",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn {
            items(complaintList, key = { it.hashCode() }) { complaint ->
                ComplaintItem(
                    complaint = complaint,
                    onDelete = {
                        viewModel.deleteComplaint(complaint)
                    }
                )
            }
        }
    }
}

@Composable
fun ComplaintItem(
    complaint: Complaint,
    onDelete: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = complaint.title,
                style = MaterialTheme.typography.titleLarge
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(text = complaint.description)

            Spacer(modifier = Modifier.height(12.dp))

            Button(
                onClick = { onDelete() }
            ) {
                Text("Delete")
            }
        }
    }
}
