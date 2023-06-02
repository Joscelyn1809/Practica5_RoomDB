package com.example.practica5_roomdb.data.room.events

import com.example.practica5_roomdb.data.room.models.City
import com.example.practica5_roomdb.data.room.sorts.SortCityType

sealed interface CityEvent{
    object SaveCity : CityEvent
    data class SetCityName(val cityName: String) : CityEvent
    data class SetCityDistrict(val cityDistrict: String) : CityEvent
    data class SetCityPopulation(val cityPopulation: Int) : CityEvent
    object ShowDialog : CityEvent
    object HideDialog : CityEvent
    data class SortCities(val sortCityType: SortCityType) : CityEvent
    data class DeleteCity(val City: City) : CityEvent
}