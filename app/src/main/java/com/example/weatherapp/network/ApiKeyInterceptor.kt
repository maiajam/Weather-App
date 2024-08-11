package com.example.weatherapp.network

import com.example.weatherapp.util.Constant
import okhttp3.Interceptor
import okhttp3.Response

class ApiKeyInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val originalUrl = chain.request().url()
        val urlWithApiKey =
            originalUrl.newBuilder()
                .addQueryParameter("appid", Constant.API_KEY)
                .build()
        val requestWithApiKey = chain.request().newBuilder().url(urlWithApiKey).build()
        return chain.proceed(requestWithApiKey)
    }
}