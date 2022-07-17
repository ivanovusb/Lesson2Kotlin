package com.example.lesson2kotlin.viewmodel

import com.example.lesson2kotlin.domain.Weather

sealed class AppState {
    data class SuccessSingle(val weatherData: Weather) : AppState()
    data class SuccessGlobal(val weatherList: List<Weather>) : AppState()
    data class Error(val weatherData: Throwable) : AppState()
    object Loading : AppState()
}