package com.example.weatherapp.data.local.repo

import com.example.weatherapp.data.local.remote.WeatherApiService
import com.example.weatherapp.data.model.CurrentWeather
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.FlowCollector
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class WeatherRepo @Inject constructor(weatherApiService: WeatherApiService) {

    val currentWeather : Flow<CurrentWeather> = flow {
        val currency = weatherApiService.getCurrentWeather("Jordan")
        emit(currency)
    }

}