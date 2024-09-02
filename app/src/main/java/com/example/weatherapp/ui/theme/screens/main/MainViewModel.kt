package com.example.weatherapp.ui.theme.screens.main

import android.location.Location
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableLongStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherapp.data.local.repo.WeatherRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class MainViewModel @Inject constructor(weatherRepo: WeatherRepo):ViewModel() {

   private val currentWeatheState = MutableStateFlow<Int>(0)
   val _currentWeatherState = currentWeatheState

   init {
       viewModelScope.launch {
          weatherRepo.currentWeather.collect{ currentWeather ->
             currentWeatheState.value = currentWeather
          }
       }
   }
}