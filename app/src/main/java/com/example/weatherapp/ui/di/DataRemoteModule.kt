package com.example.weatherapp.ui.di

import com.example.weatherapp.data.repository.InfoHourRemote
import com.example.weatherapp.dataRemote.api.ServiceFactory
import com.example.weatherapp.dataRemote.api.ServiceInfoHour
import com.example.weatherapp.dataRemote.repository.RemoteImplInfoHour
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
    fun provideInfoHourRemote(remoteImplInfoHour: RemoteImplInfoHour) : InfoHourRemote =
        remoteImplInfoHour

    @Provides
    @Singleton
    fun serviceInfoHour() : ServiceInfoHour =
        ServiceFactory.create(true, baseUrl)

    private val baseUrl = "https://api.openweathermap.org/data/2.5/" //todo store url in another place


}