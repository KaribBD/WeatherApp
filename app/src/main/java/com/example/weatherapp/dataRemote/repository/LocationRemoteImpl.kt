package com.example.weatherapp.dataRemote.repository

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.os.Looper
import androidx.core.app.ActivityCompat
import com.example.weatherapp.data.model.CoordinatesEntity
import com.example.weatherapp.data.repository.LocationRemote
import com.google.android.gms.location.LocationCallback
import com.google.android.gms.location.LocationRequest
import com.google.android.gms.location.LocationResult
import com.google.android.gms.location.LocationServices
import com.google.android.gms.location.Priority
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import javax.inject.Inject

class LocationRemoteImpl @Inject constructor(
    @ApplicationContext private val context: Context,
) : LocationRemote {
    private val locationRequest by lazy {
        LocationRequest.Builder(Priority.PRIORITY_HIGH_ACCURACY, LOCATION_REQUEST_INTERVAL)
            .setMinUpdateIntervalMillis(LOCATION_REQUEST_FASTEST_INTERVAL)
            .setMaxUpdateDelayMillis(LOCATION_MAX_WAIT_TIME)
            .setWaitForAccurateLocation(false)
            .build()
    }


    private val locationClient by lazy { LocationServices.getFusedLocationProviderClient(context) }

    override suspend fun getLocation(): Flow<CoordinatesEntity> {
        if (ActivityCompat.checkSelfPermission(
                context,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                context,
                Manifest.permission.ACCESS_COARSE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            throw Exception("Location permission wasn't granted") //todo change!
        }

        return callbackFlow {

            val callBack = object : LocationCallback() {
                override fun onLocationResult(locationResult: LocationResult) {
                    super.onLocationResult(locationResult)
                    val location = locationResult.lastLocation
                    if (location != null) {
                        val userLocation = CoordinatesEntity(
                            latitude = location.latitude,
                            longitude = location.longitude
                        )
                        trySend(userLocation).isSuccess
                    } else {
                        throw Exception("Location == null") //todo change!
                    }

                }
            }

            locationClient.requestLocationUpdates(locationRequest, callBack, Looper.getMainLooper())
            awaitClose {
                locationClient.removeLocationUpdates(callBack)
            }
        }

    }

    companion object {
        const val LOCATION_REQUEST_INTERVAL = 8000L
        const val LOCATION_REQUEST_FASTEST_INTERVAL = 4000L
        const val LOCATION_MAX_WAIT_TIME = 2_000_000L
    }
}