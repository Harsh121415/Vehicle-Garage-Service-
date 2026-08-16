package com.example.localvehicleandgaragebookingapp.booking

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Text

class SlotSelectionActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val garageName = intent.getStringExtra("garageName")
        val serviceName = intent.getStringExtra("serviceName")
        setContent {
            Text(text = "Selecting slot for $serviceName at $garageName")
        }
    }
}
