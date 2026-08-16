package com.example.localvehicleandgaragebookingapp.complaint

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.localvehicleandgaragebookingapp.viewmodel.ComplaintViewModel

class CreateComplaintActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CreateComplaintScreen()
        }
    }
}

@Composable
fun CreateComplaintScreen() {

    var title by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }

    val viewModel: ComplaintViewModel = viewModel()
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize()
    ) {

        Text(
            text = "Create Complaint",
            style = MaterialTheme.typography.headlineSmall
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = title,
            onValueChange = { title = it },
            label = { Text("Complaint Title") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(14.dp))

        OutlinedTextField(
            value = description,
            onValueChange = { description = it },
            label = { Text("Description") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = {

                // 🔥 Validation
                if (title.isBlank() || description.isBlank()) {
                    Toast.makeText(context, "Fill all fields", Toast.LENGTH_SHORT).show()
                } else {

                    // 🔥 Supabase call via ViewModel
                    viewModel.addComplaint(title, description)

                    Toast.makeText(context, "Complaint Submitted", Toast.LENGTH_SHORT).show()

                    // 🔥 Clear fields (important UX)
                    title = ""
                    description = ""

                    // 🔥 Navigate to list
                    context.startActivity(
                        Intent(context, ComplaintListActivity::class.java)
                    )
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Submit Complaint")
        }
    }
}