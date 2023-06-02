package com.example.practica5_roomdb.data.room.daos

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import com.example.practica5_roomdb.data.room.models.City
import kotlinx.coroutines.flow.Flow

@Dao
interface CityDao {
    @Upsert
    suspend fun insert(city: City)

    @Delete
    suspend fun delete(city: City)

    @Query("SELECT * FROM CITY_TABLE")
    fun getAllCities(): Flow<List<City>>

    @Query("SELECT * FROM CITY_TABLE ORDER BY cityName ASC")
    fun getAllCitiesOrderedByName(): Flow<List<City>>

    @Query("SELECT * FROM CITY_TABLE ORDER BY cityPopulation ASC")
    fun getAllCitiesOrderedByPopulation(): Flow<List<City>>

    @Query("SELECT * FROM CITY_TABLE WHERE cityId =:id")
    fun getCity(id: Int): Flow<City>
}