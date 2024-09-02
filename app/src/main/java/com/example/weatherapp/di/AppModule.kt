package com.example.weatherapp.di

import androidx.compose.ui.tooling.preview.Preview
import com.example.weatherapp.data.local.remote.WeatherApiService
import com.example.weatherapp.network.ApiKeyInterceptor
import com.example.weatherapp.util.Constant
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import java.sql.ClientInfoStatus
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule  {

    @Provides
    @Singleton
    fun provideApiService():WeatherApiService{
        return Retrofit.Builder()
            .baseUrl(Constant.BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create(Moshi.Builder().build()))
            .client(
                OkHttpClient().newBuilder()
                    .addInterceptor(ApiKeyInterceptor())
                    .build()
            )
            .build()
            .create()
    }

}