package com.example.weatherapp.ui.di

import com.example.weatherapp.data.LocationEntityRepository
import com.example.weatherapp.data.InfoHourRepositoryImpl
import com.example.weatherapp.domain.repository.LocationRepository
import com.example.weatherapp.domain.repository.InfoHourRepository
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
    fun provideHourListRepository(repositoryImplInfoHour: InfoHourRepositoryImpl) : InfoHourRepository =
        repositoryImplInfoHour

    @Provides
    @Singleton
    fun provideCoordinatesRepository(locationEntityRepository: LocationEntityRepository): LocationRepository =
        locationEntityRepository
}