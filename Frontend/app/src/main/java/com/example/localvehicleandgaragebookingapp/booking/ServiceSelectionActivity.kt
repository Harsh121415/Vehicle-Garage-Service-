package com.example.localvehicleandgaragebookingapp.booking

import android.content.Intent
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

data class Service(
    val name: String,
    val price: String
)

class ServiceSelectionActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val garageName = intent.getStringExtra("garageName") ?: ""
        setContent {
            ServiceSelectionScreen(this, garageName)
        }
    }
}

@Composable
fun ServiceSelectionScreen(activity: ComponentActivity, garageName: String) {
    val serviceList = listOf(
        Service("Oil Change", "₹500"),
        Service("Car Wash", "₹300"),
        Service("Engine Check", "₹700")
    )
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Garage: $garageName",
            style = MaterialTheme.typography.titleLarge
        )
        Spacer(modifier = Modifier.height(12.dp))
        Text(
            text = "Select Service",
            style = MaterialTheme.typography.headlineMedium
        )
        Spacer(modifier = Modifier.height(16.dp))
        LazyColumn {
            items(serviceList) { service ->
                ServiceItem(service) {
                    // Note: SlotSelectionActivity needs to be created
                    val intent = Intent(activity, SlotSelectionActivity::class.java)
                    intent.putExtra("garageName", garageName)
                    intent.putExtra("serviceName", service.name)
                    activity.startActivity(intent)
                }
            }
        }
    }
}

@Composable
fun ServiceItem(
    service: Service,
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
                text = service.name,
                style = MaterialTheme.typography.titleLarge
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = service.price)
        }
    }
}
