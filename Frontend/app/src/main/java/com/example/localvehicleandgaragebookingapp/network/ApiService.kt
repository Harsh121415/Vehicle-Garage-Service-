package com.example.localvehicleandgaragebookingapp.network

import com.example.localvehicleandgaragebookingapp.data.model.LoginRequest
import com.example.localvehicleandgaragebookingapp.data.model.LoginResponse
import com.example.localvehicleandgaragebookingapp.data.model.RegisterRequest
import com.example.localvehicleandgaragebookingapp.data.model.RegisterResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {

    @POST("api/auth/login")
    suspend fun login(@Body request: LoginRequest): Response<LoginResponse>

    @POST("api/auth/register")
    suspend fun register(@Body request: RegisterRequest): Response<RegisterResponse>

    // Added missing Booking model or used Any for now to fix redlines
    @GET("api/bookings")
    suspend fun getBookings(): Response<List<Any>>
}
