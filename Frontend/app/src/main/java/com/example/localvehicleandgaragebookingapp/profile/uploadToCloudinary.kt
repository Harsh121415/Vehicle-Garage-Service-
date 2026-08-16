package com.example.localvehicleandgaragebookingapp.profile
import android.util.Log
import com.cloudinary.android.callback.UploadCallback
import android.net.Uri
import com.cloudinary.android.callback.ErrorInfo
import com.cloudinary.android.MediaManager
fun uploadToCloudinary(
    imageUri: Uri,
    onStart: () -> Unit,
    onSuccess: (String) -> Unit,
    onError: () -> Unit
) {
    MediaManager.get().upload(imageUri)
        .callback(object : UploadCallback {

            override fun onStart(requestId: String?) {
                onStart()
            }

            override fun onSuccess(requestId: String?, resultData: Map<*, *>?) {
                val url = resultData?.get("secure_url").toString()
                Log.d("CLOUDINARY", url)
                onSuccess(url)
            }

            override fun onError(requestId: String?, error: ErrorInfo?) {
                onError()
            }

            override fun onProgress(requestId: String?, bytes: Long, totalBytes: Long) {}

            override fun onReschedule(requestId: String?, error: ErrorInfo?) {}
        })
        .dispatch()
}