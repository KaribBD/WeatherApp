package com.example.weatherapp.ui.di

import com.example.weatherapp.data.LocationRepositoryImpl
import com.example.weatherapp.data.WeatherRepositoryImpl
import com.example.weatherapp.domain.repository.LocationRepository
import com.example.weatherapp.domain.repository.WeatherRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Provides
    @Singleton
    fun provideHourListRepository(weatherRepositoryImpl: WeatherRepositoryImpl) : WeatherRepository =
        weatherRepositoryImpl

    @Provides
    @Singleton
    fun provideCoordinatesRepository(locationRepositoryImpl: LocationRepositoryImpl): LocationRepository =
        locationRepositoryImpl

}