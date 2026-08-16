package com.example.localvehicleandgaragebookingapp.profile

import android.net.Uri
import android.util.Log
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.cloudinary.android.MediaManager
import com.cloudinary.android.callback.ErrorInfo
import com.cloudinary.android.callback.UploadCallback

@Composable
fun ProfileScreen() {

    val context = LocalContext.current
    var imageUrl by remember { mutableStateOf("") }
    var isUploading by remember { mutableStateOf(false) }


    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) { uri: Uri? ->
        uri?.let {
            uploadToCloudinary(it,
                onStart = { isUploading = true },
                onSuccess = { url ->
                    isUploading = false
                    imageUrl = url
                    Toast.makeText(context, "Uploaded!", Toast.LENGTH_SHORT).show()
                },
                onError = {
                    isUploading = false
                    Toast.makeText(context, "Upload Failed", Toast.LENGTH_SHORT).show()
                }
            )
        }
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text("Profile", style = MaterialTheme.typography.headlineMedium)

        Spacer(modifier = Modifier.height(20.dp))

        Button(onClick = {
            launcher.launch("image/*")
        }) {
            Text("Upload Profile Image")
        }

        Spacer(modifier = Modifier.height(20.dp))

        if (isUploading) {
            CircularProgressIndicator()
        }

        if (imageUrl.isNotEmpty()) {
            Text("Image URL:")
            Text(imageUrl)
        }
    }
}