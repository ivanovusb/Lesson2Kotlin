package com.example.lesson2kotlin.view.details

import com.example.lesson2kotlin.domain.Weather

fun interface OnItemClick {
    fun onItemClick(weather: Weather)
}