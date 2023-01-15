package com.example.weatherapp.data.repository

import com.example.weatherapp.data.model.EntityInfoHour

interface InfoHourDataSource {
    suspend fun getInfoHours(): List<EntityInfoHour>
}