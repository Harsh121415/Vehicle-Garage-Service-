package com.example.localvehicleandgaragebookingapp.network

import android.content.Context
import com.example.localvehicleandgaragebookingapp.utils.PrefsHelper
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {

    private const val BASE_URL ="http://10.0.2.2:8080/"

    private fun getOkHttpClient(context: Context): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor { chain ->
                val original = chain.request()
                val token = PrefsHelper.getToken(context)
                
                val requestBuilder = original.newBuilder()
                if (token != null) {
                    requestBuilder.header("Authorization", "Bearer $token")
                }
                
                val request = requestBuilder.method(original.method, original.body).build()
                chain.proceed(request)
            }
            .build()
    }

    // Singleton instance for general use (without token interceptor if needed)
    val api: ApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }

    // Method to get client with Auth Header
    fun getAuthenticatedApi(context: Context): ApiService {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(getOkHttpClient(context))
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }
}
