package com.example.weatherapp.ui.di

import com.example.weatherapp.data.repository.InfoHourCache
import com.example.weatherapp.dataCache.repository.InfoHourCacheImpl
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
    fun provideInfoHourCache(infoHourCacheImpl: InfoHourCacheImpl) : InfoHourCache =
        infoHourCacheImpl
}