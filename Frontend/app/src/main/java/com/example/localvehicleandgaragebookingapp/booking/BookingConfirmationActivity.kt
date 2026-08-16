package com.example.localvehicleandgaragebookingapp.booking

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

class BookingConfirmationActivity:ComponentActivity(){
    override fun onCreate(savedInstanceState:Bundle?) {
        super.onCreate(savedInstanceState)

        val garageName = intent.getStringExtra("garageName") ?: ""
        val serviceName = intent.getStringExtra("serviceName") ?: ""
        val slotTime = intent.getStringExtra("slotTime") ?: ""

        setContent {
            BookingConfirmationScreen(
                garageName,
                serviceName,
                slotTime,
                this
            )
        }
    }
}

@Composable
fun BookingConfirmationScreen(
    garageName:String,
    serviceName:String,
    slotTime:String,
    activity: ComponentActivity
){
    Column(
        modifier= Modifier
            .fillMaxSize()
            .padding(16.dp)
    ){
        Text(
            text="Booking Confirmation",
            style=MaterialTheme.typography.headlineMedium
        )
        Spacer(modifier=Modifier.height(16.dp))

        Text(text="Garage:$garageName")
        Text(text="Service:$serviceName")
        Text(text="Time:$slotTime")

        Spacer(modifier=Modifier.height(24.dp))

        Button(
            onClick = {
                Toast.makeText(activity,"Booking Confirmed!",Toast.LENGTH_SHORT).show()
            },
            modifier=Modifier.fillMaxWidth()
        ){
            Text("Confirm Booking")
        }
    }
}