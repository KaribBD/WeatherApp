package com.example.weatherapp.dataRemote.api

import com.example.weatherapp.dataRemote.models.ModelResponseInfoHour
import retrofit2.http.GET

import retrofit2.http.Query


interface InfoHourService {

    @GET("forecast")
    suspend fun getInfoHour(
        @Query("lat") lat: Double,
        @Query("lon") lon: Double,
        @Query("appid") appid: String,
        @Query("units") units: String
    ): ModelResponseInfoHour

}

enum class Units(val unit: String) {
    KELVIN("standard"),
    FAHRENHEIT("imperial"),
    CELSIUS("metric")
}