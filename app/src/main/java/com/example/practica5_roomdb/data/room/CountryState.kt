package com.example.practica5_roomdb.data.room

import com.example.practica5_roomdb.data.room.models.Country
import com.example.practica5_roomdb.data.room.sorts.SortType

data class CountryState(
    val countries: List<Country> = emptyList(),
    val countryName: String = "",
    val countryContinent: String = "",
    val isAddingCountry: Boolean = false,
    val sortType: SortType = SortType.COUNTRY_NAME
)
