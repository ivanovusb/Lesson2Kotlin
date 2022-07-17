package com.example.lesson2kotlin.model

import com.example.lesson2kotlin.domain.Weather
import com.example.lesson2kotlin.domain.getRussianCities
import com.example.lesson2kotlin.domain.getWorldCities
import com.example.lesson2kotlin.viewmodel.AppState

class RepositoryRemoteImpl: RepositorySingle {

    override fun getWeather(lat: Double, lon: Double): Weather {
        Thread { //запрос в репозиторий..
            Thread.sleep(300L)
        }.start()
        return Weather()
    }
}