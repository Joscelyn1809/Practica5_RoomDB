package com.example.practica5_roomdb.data.room.daos

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import com.example.practica5_roomdb.data.room.models.Country
import kotlinx.coroutines.flow.Flow

@Dao
interface CountryDao {
    @Upsert //Añade o reemplaza según sea el caso
    suspend fun upsertCountry(country: Country)

    @Delete
    suspend fun deleteCountry(country: Country)

    @Query("SELECT * FROM COUNTRY_TABLE")
    fun getAllCountries(): Flow<List<Country>>

    @Query("SELECT * FROM COUNTRY_TABLE ORDER BY countryName ASC")
    fun getAllCountriesOrderedByName(): Flow<List<Country>>

    @Query("SELECT * FROM COUNTRY_TABLE ORDER BY countryContinent ASC")
    fun getAllCountriesOrderedByContinent(): Flow<List<Country>>

    @Query("SELECT * FROM COUNTRY_TABLE WHERE countryId =:id")
    fun getCountry(id: Int): Flow<Country>
}