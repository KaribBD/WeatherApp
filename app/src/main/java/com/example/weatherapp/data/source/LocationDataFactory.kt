package com.example.weatherapp.data.source

import android.content.Context
import com.example.weatherapp.data.repository.LocationEntityData
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class LocationDataFactory @Inject constructor(
    @ApplicationContext private val context: Context
) {
    fun createData(source: SourceName): LocationEntityData {
        return when (source) {
            SourceName.Network -> LocationEntityDataRemote(context)
            //Source.Local -> LocalLocationEntityData(context)
            // Source.Mock -> MockLocationEntityData(context)
            // ...
            else -> {
                throw Exception()//todo change exception
            }
        }
    }

    enum class SourceName{
        Network,
        Local
    }
}