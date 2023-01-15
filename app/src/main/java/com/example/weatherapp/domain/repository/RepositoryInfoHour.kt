package com.example.weatherapp.domain.repository

import com.example.weatherapp.domain.models.InfoHour
import kotlinx.coroutines.flow.Flow

interface RepositoryInfoHour {
    //Remote
    suspend fun getWeatherHoursList(): Flow<List<InfoHour>>
}