package com.example.weatherapp.data.local.repo

import com.example.weatherapp.data.local.remote.WeatherApiService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.FlowCollector
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class WeatherRepo @Inject constructor(weatherApiService: WeatherApiService) {

    val currentWeather : Flow<Int> = flow {
        val currency = weatherApiService.getCurrentWeather(30.0,20.0).dt
        emit(currency)
    }

}