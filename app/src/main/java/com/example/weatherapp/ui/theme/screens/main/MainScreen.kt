package com.example.weatherapp.ui.theme.screens.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.weatherapp.Greeting
import com.example.weatherapp.R
import com.example.weatherapp.ui.theme.WeatherAppTheme
import dagger.hilt.android.lifecycle.HiltViewModel

@Composable
fun MainScreen(mainViewModel: MainViewModel = hiltViewModel()){

    var currentWeather = mainViewModel._currentWeatherState.collectAsState()
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = currentWeather.value?.name.toString(),
            modifier = Modifier.padding(2.dp), fontSize = 30.sp,
            fontWeight = FontWeight.Bold
        )
        Image(
            painter = painterResource(id = R.drawable.sunny), contentDescription = "its sunny",
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
        )
        Text(
            text = currentWeather.value?.weather?.get(0)?.description.toString(),
            modifier = Modifier.padding(2.dp), fontSize = 30.sp,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = currentWeather.value?.main?.temp.toString(),
            modifier = Modifier.padding(2.dp), fontSize = 30.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

@Preview
@Composable
fun MainPreview(){
    WeatherAppTheme {
      MainScreen()
    }
}