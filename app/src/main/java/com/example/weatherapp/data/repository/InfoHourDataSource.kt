package com.example.weatherapp.data.repository

import com.example.weatherapp.data.model.CoordinatesEntity
import com.example.weatherapp.data.model.InfoHourEntity

interface InfoHourDataSource {
    suspend fun getInfoHours(coordinates: CoordinatesEntity): List<InfoHourEntity>
}