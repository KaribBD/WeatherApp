package com.example.weatherapp.data

import com.example.weatherapp.data.mapper.CoordinatesMapper
import com.example.weatherapp.data.mapper.DailyWeatherMapper
import com.example.weatherapp.data.mapper.HourlyWeatherMapper
import com.example.weatherapp.data.source.WeatherDataSourceFactory
import com.example.weatherapp.domain.models.Coordinates
import com.example.weatherapp.domain.models.DayWeather
import com.example.weatherapp.domain.models.HourWeather
import com.example.weatherapp.domain.repository.WeatherRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(
    private val weatherDataSourceFactory: WeatherDataSourceFactory,
    private val hourlyWeatherMapper: HourlyWeatherMapper,
    private val dailyWeatherMapper: DailyWeatherMapper,
    private val coordinatesMapper: CoordinatesMapper
) : WeatherRepository {

    override suspend fun getHourlyWeatherList(coordinates: Coordinates): Flow<List<HourWeather>> = flow {
        val entityCoordinates = coordinatesMapper.mapToEntity(coordinates)

        val hourWeatherList =
            weatherDataSourceFactory.getDataStore().getHourlyWeather(entityCoordinates).map { hourlyWeatherEntity ->
                hourlyWeatherMapper.mapFromEntity(hourlyWeatherEntity)
            }
        emit(hourWeatherList)
    }

    override suspend fun getDailyWeatherList(coordinates: Coordinates): Flow<List<DayWeather>> = flow {
        val entityCoordinates = coordinatesMapper.mapToEntity(coordinates)

        val dailyWeatherList =
            weatherDataSourceFactory.getDataStore().getDailyWeather(entityCoordinates).map { dailyWeatherEntity ->
                dailyWeatherMapper.mapFromEntity(dailyWeatherEntity)
            }
        emit(dailyWeatherList)
    }

}