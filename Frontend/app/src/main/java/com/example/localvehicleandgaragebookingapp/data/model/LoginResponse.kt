package com.example.localvehicleandgaragebookingapp.data.model

data class LoginResponse(
    val token: String,
    val user: User
)

data class User(
    val name: String,
    val email: String
)
