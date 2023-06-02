package com.example.practica5_roomdb.data.room.events

import com.example.practica5_roomdb.data.room.sorts.SortType
import com.example.practica5_roomdb.data.room.models.Country

sealed interface CountryEvent {
    object SaveCountry : CountryEvent
    data class SetCountryName(val countryName: String) : CountryEvent
    data class SetCountryContinent(val countryContinent: String) : CountryEvent
    object ShowDialog : CountryEvent
    object HideDialog : CountryEvent
    data class SortCountries(val sortType: SortType) : CountryEvent
    data class DeleteCountry(val country: Country) : CountryEvent
}