package com.example.weatherapp.ui.di

import com.example.weatherapp.data.repository.WeatherRemote
import com.example.weatherapp.dataRemote.api.WeatherService
import com.example.weatherapp.dataRemote.api.WeatherServiceFactory
import com.example.weatherapp.dataRemote.repository.WeatherRemoteImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataRemoteModule {

    @Provides
    @Singleton
    fun provideInfoHourRemote(weatherRemoteImpl: WeatherRemoteImpl) : WeatherRemote =
        weatherRemoteImpl

    @Provides
    @Singleton
    fun serviceInfoHour() : WeatherService =
        WeatherServiceFactory.create(true, baseUrl)

    private val baseUrl = "https://api.open-meteo.com/v1/" //todo store url in another place

}