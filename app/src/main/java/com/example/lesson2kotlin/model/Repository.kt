package com.example.lesson2kotlin.model

import com.example.lesson2kotlin.domain.Weather

fun interface RepositorySingle {
    fun getWeather(lat: Double, lon: Double): Weather
}

fun interface RepositoryGlobal {
    fun getListWeather(location: Location): List<Weather>
}

sealed class Location {
    object Russian: Location()
    object World: Location()
}