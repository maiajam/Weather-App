package com.example.weatherapp.data.local.remote


import com.example.weatherapp.data.model.Weather
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApiService {

    @GET("weather")
    suspend fun getCurrentWeather(
        @Query("lat") lat: Double,
        @Query("lon") lon: Double
    ):Weather
}