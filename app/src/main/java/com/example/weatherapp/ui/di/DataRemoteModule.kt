package com.example.weatherapp.ui.di

import com.example.weatherapp.data.repository.InfoHourRemote
import com.example.weatherapp.dataRemote.api.InfoHourServiceFactory
import com.example.weatherapp.dataRemote.api.InfoHourService
import com.example.weatherapp.dataRemote.repository.InfoHourRemoteImpl
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
    fun provideInfoHourRemote(infoHourRemoteImpl: InfoHourRemoteImpl) : InfoHourRemote =
        infoHourRemoteImpl

    @Provides
    @Singleton
    fun serviceInfoHour() : InfoHourService =
        InfoHourServiceFactory.create(true, baseUrl)

    private val baseUrl = "https://api.openweathermap.org/data/2.5/" //todo store url in another place


}