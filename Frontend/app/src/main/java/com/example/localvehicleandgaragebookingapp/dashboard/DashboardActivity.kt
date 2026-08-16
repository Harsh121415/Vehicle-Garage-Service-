package com.example.localvehicleandgaragebookingapp.dashboard

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity
import com.example.localvehicleandgaragebookingapp.R
import com.example.localvehicleandgaragebookingapp.utils.SharedPrefManager
import com.example.localvehicleandgaragebookingapp.complaint.CreateComplaintActivity
import com.example.localvehicleandgaragebookingapp.booking.GarageListActivity
import com.example.localvehicleandgaragebookingapp.profile.ProfileActivity
import com.example.localvehicleandgaragebookingapp.auth.LoginActivity

class DashBoardActivity : ComponentActivity() {

    private lateinit var btnComplaint: Button
    private lateinit var btnLogout: Button
    private lateinit var btnProfile: Button
    private lateinit var btnBooking: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        btnComplaint = findViewById(R.id.btnComplaint)
        btnBooking = findViewById(R.id.btnBooking)
        btnLogout = findViewById(R.id.btnLogout)
        btnProfile = findViewById(R.id.btnProfile)

        btnComplaint.setOnClickListener {
            startActivity(Intent(this, CreateComplaintActivity::class.java))
        }

        btnBooking.setOnClickListener {
            startActivity(Intent(this, GarageListActivity::class.java))
        }

        btnProfile.setOnClickListener {
            startActivity(Intent(this, ProfileActivity::class.java))
        }

        btnLogout.setOnClickListener {
            SharedPrefManager.clearUser(this)
            val intent = Intent(this, LoginActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
        }
    }
}
