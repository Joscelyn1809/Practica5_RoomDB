package com.example.practica5_roomdb.data.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.practica5_roomdb.data.room.daos.CountryDao
import com.example.practica5_roomdb.data.room.models.Country

@Database(
    entities = [Country::class],
    version = 1,
    exportSchema = false
)
abstract class CountryDB : RoomDatabase() {
    abstract val countryDao: CountryDao
}