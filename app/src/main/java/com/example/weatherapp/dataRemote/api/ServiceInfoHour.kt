package com.example.weatherapp.dataRemote.api

import com.example.weatherapp.dataRemote.models.ModelResponseInfoHour
import retrofit2.http.GET
import com.squareup.moshi.JsonClass

import com.squareup.moshi.Json
import retrofit2.http.Query


interface ServiceInfoHour {

    @GET("forecast")
    suspend fun getInfoHour(
        @Query("lat") lat: Double,
        @Query("lon") lon: Double,
        @Query("appid") appid: String)
    : ModelResponseInfoHour
}