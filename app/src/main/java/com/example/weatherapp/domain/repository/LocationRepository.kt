package com.example.weatherapp.domain.repository

import com.example.weatherapp.domain.models.Coordinates
import kotlinx.coroutines.flow.Flow

interface LocationRepository {
    suspend fun getLocation(): Flow<Coordinates>
}