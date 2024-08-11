package com.example.weatherapp.data.local.remote


import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApiService {

    @GET("onecall")
    suspend fun getCurrentWeather(
        @Query("lat") lat: Double,
        @Query("lon") lon: Double
    )
}