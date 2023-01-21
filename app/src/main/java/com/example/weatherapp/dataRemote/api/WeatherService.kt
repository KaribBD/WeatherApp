package com.example.weatherapp.dataRemote.api

import com.example.weatherapp.dataRemote.models.DailyWeatherResponseModel
import com.example.weatherapp.dataRemote.models.HourlyWeatherResponseModel
import retrofit2.http.GET

import retrofit2.http.Query


interface WeatherService {

    @GET("forecast")
    suspend fun getHourlyWeather(
        @Query("latitude") latitude: Double,
        @Query("longitude") longitude: Double,
        @Query("hourly", encoded = true) hourly: String,
    ): HourlyWeatherResponseModel

    @GET("forecast")
    suspend fun getDailyWeather(
        @Query("latitude") latitude: Double,
        @Query("longitude") longitude: Double,
        @Query("daily", encoded = true) daily: String,
        @Query("timezone", encoded = true) timezone: String
    ) : DailyWeatherResponseModel

}