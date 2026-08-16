package com.example.localvehicleandgaragebookingapp.utils

import android.content.Context
import com.cloudinary.android.MediaManager

object CloudinaryManager {

    fun init(context: Context) {
        val config = HashMap<String, String>()

        config["cloud_name"] = "dxhgqg6yu"
        config["api_key"] = "988412535944928"
        config["api_secret"] = "Q_zOjH-Tx0F1syio8cIDwG3U4t8"

        MediaManager.init(context, config)
    }
}