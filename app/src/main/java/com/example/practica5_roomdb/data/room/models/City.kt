package com.example.practica5_roomdb.data.room.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "CITY_TABLE")
data class City(
    val cityName: String,
    val cityDistrict: String,
    val cityPopulation: Int,
    val countryCodeFK: Int,
    @PrimaryKey(autoGenerate = true)
    val cityId: Int = 0
)