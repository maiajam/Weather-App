package com.example.weatherapp.ui.theme.screens.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberAsyncImagePainter
import com.example.weatherapp.ui.theme.WeatherAppTheme
import com.example.weatherapp.util.Constant

@Composable
fun MainScreen(mainViewModel: MainViewModel = hiltViewModel()){

    val currentWeather = mainViewModel._currentWeatherState.collectAsState()
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
       WeatherIcon(currentWeather.value?.weather?.get(0)?.icon)
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

@Composable
fun WeatherIcon(icon: String?) {
    val iconUrl = Constant.BASE_ICON_URL + "/${icon}@2x.png"
    Image(
        painter = rememberAsyncImagePainter(model = iconUrl),
        contentDescription = "dsfs",
        contentScale = ContentScale.Fit,
        modifier = Modifier.size(100.dp),
    )
}

@Preview
@Composable
fun MainPreview(){
    WeatherAppTheme {
      MainScreen()
    }
}