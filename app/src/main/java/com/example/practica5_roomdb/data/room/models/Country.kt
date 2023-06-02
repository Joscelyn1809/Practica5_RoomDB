package com.example.practica5_roomdb.data.room.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "COUNTRY_TABLE")
data class Country(
    val countryName: String,
    val countryContinent: String,
    @PrimaryKey(autoGenerate = true)
    val countryId: Int? = null,
)
