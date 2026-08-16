package com.example.localvehicleandgaragebookingapp.booking

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
import android.content.Intent

data class Garage(
    val name: String,
    val location: String
)

class GarageListActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GarageListScreen(this)
        }
    }
}

@Composable
fun GarageListScreen(activity: ComponentActivity) {
    val garageList = listOf(
        Garage("AutoFix Garage", "Delhi"),
        Garage("Speed Motors", "Noida"),
        Garage("Car Care Center", "Gurgaon")
    )
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Select Garage",
            style = MaterialTheme.typography.headlineMedium
        )
        Spacer(modifier = Modifier.height(16.dp))
        LazyColumn {
            items(garageList) { garage ->
                GarageItem(garage) {
                    val intent = Intent(activity, ServiceSelectionActivity::class.java)
                    intent.putExtra("garageName", garage.name)
                    activity.startActivity(intent)
                }
            }
        }
    }
}

@Composable
fun GarageItem(
    garage: Garage,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        elevation = CardDefaults.cardElevation(4.dp),
        onClick = { onClick() }
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = garage.name,
                style = MaterialTheme.typography.titleLarge
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = garage.location)
        }
    }
}
