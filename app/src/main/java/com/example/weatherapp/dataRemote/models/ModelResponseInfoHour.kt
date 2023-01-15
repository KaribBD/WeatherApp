package com.example.weatherapp.dataRemote.models

import com.squareup.moshi.Json

//generated by Plugin JSON to Kotlin Class using the example from this page:
// https://openweathermap.org/forecast5

data class ModelResponseInfoHour(
    @Json(name = "city")
    val city: City,
    @Json(name = "cnt")
    val cnt: Int,
    @Json(name = "cod")
    val cod: String,
    @Json(name = "list")
    val list: List<WeatherListItem>,
    @Json(name = "message")
    val message: Int
)

data class City(
    @Json(name = "coord")
    val coord: Coord,
    @Json(name = "country")
    val country: String,
    @Json(name = "id")
    val id: Int,
    @Json(name = "name")
    val name: String,
    @Json(name = "population")
    val population: Int,
    @Json(name = "sunrise")
    val sunrise: Int,
    @Json(name = "sunset")
    val sunset: Int,
    @Json(name = "timezone")
    val timezone: Int
)

data class WeatherListItem(
    @Json(name = "clouds")
    val clouds: Clouds,
    @Json(name = "dt")
    val dt: Int,
    @Json(name = "dt_txt")
    val dt_Txt: String,
    @Json(name = "main")
    val main: Main,
    @Json(name = "pop")
    val pop: Double,
    @Json(name = "rain")
    val rain: Rain,
    @Json(name = "sys")
    val sys: Sys,
    @Json(name = "visibility")
    val visibility: Int,
    @Json(name = "weather")
    val weather: List<Weather>,
    @Json(name = "wind")
    val wind: Wind
)

data class Coord(
    @Json(name = "lat")
    val lat: Double,
    @Json(name = "lon")
    val lon: Double
)

data class Clouds(
    @Json(name = "all")
    val all: Int
)

data class Main(
    @Json(name = "feels_like")
    val feelsLike: Double,
    @Json(name = "grnd_level")
    val grndLevel: Int,
    @Json(name = "humidity")
    val humidity: Int,
    @Json(name = "pressure")
    val pressure: Int,
    @Json(name = "sea_level")
    val seaLevel: Int,
    @Json(name = "temp")
    val temp: Double,
    @Json(name = "temp_kf")
    val tempKf: Double,
    @Json(name = "temp_max")
    val tempMax: Double,
    @Json(name = "temp_min")
    val tempMin: Double
)

data class Rain(
    @Json(name = "3h")
    val h: Double
)

data class Sys(
    @Json(name = "pod")
    val pod: String
)

data class Weather(
    @Json(name = "description")
    val description: String,
    @Json(name = "icon")
    val icon: String,
    @Json(name = "id")
    val id: Int,
    @Json(name = "main")
    val main: String
)

data class Wind(
    @Json(name = "deg")
    val deg: Int,
    @Json(name = "gust")
    val gust: Double,
    @Json(name = "speed")
    val speed: Double
)