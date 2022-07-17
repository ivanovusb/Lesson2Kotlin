package com.example.lesson2kotlin.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.lesson2kotlin.model.*
import java.lang.Thread.sleep

class WeatherListViewModel(
    private val liveData: MutableLiveData<AppState> = MutableLiveData<AppState>()
) : ViewModel() {

    private lateinit var repositorySingle: RepositorySingle
    private lateinit var repositoryGlobal: RepositoryGlobal


    fun getLiveData(): MutableLiveData<AppState> {
        choiceRepository()
        return liveData
    }

    private fun choiceRepository() {
        repositorySingle = if (isConnection()) {
            RepositoryRemoteImpl()
        } else {
            RepositoryLocaleImpl()
        }
        repositoryGlobal = RepositoryLocaleImpl()
    }

    fun getWeatherListForRussia() {
        sentRequest(Location.Russian)
    }

    fun getWeatherListForWorld() {
        sentRequest(Location.World)
    }

    private fun sentRequest(location: Location) {
        liveData.value = AppState.Loading//пошла загрузка
        if (false) {
            liveData.postValue(AppState.Error(throw IllegalStateException("что то пошло не так!")))
        } else {
            liveData.postValue(
                AppState.SuccessGlobal(
                    repositoryGlobal.getListWeather(
                        location
                    )
                )
            )
        }
        //пришел ответ
    }

    private fun isConnection(): Boolean {
        return false;
    }
}