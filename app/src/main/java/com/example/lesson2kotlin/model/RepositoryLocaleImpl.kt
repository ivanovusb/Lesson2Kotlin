package com.example.lesson2kotlin.model

import com.example.lesson2kotlin.domain.Weather
import com.example.lesson2kotlin.domain.getRussianCities
import com.example.lesson2kotlin.domain.getWorldCities


class RepositoryLocaleImpl: RepositorySingle, RepositoryGlobal {
    override fun getListWeather(location: Location): List<Weather> {
        return when(location) {
            Location.Russian -> {
                getRussianCities()
            }
            Location.World -> {
                getWorldCities()
            }
        }
    }

    override fun getWeather(lat: Double, lon: Double): Weather {
        return Weather()
    }
}