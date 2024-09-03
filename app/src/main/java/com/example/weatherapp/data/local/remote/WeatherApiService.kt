package com.example.weatherapp.data.local.remote


import com.example.weatherapp.data.model.CurrentWeather
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApiService {

    @GET("weather")
    suspend fun getCurrentWeather(
        @Query("q") q: String,
    ):CurrentWeather
}