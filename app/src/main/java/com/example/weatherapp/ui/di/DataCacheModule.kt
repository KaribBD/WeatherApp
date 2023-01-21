package com.example.weatherapp.ui.di

import com.example.weatherapp.data.repository.WeatherCache
import com.example.weatherapp.dataCache.repository.WeatherCacheImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataCacheModule {

    @Provides
    @Singleton
    fun provideWeatherCache(weatherCacheImpl: WeatherCacheImpl) : WeatherCache =
        weatherCacheImpl
}