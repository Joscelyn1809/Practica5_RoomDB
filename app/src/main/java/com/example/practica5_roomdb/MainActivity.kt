package com.example.practica5_roomdb

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.room.Room
import com.example.practica5_roomdb.data.room.CountryDB
import com.example.practica5_roomdb.data.room.viewModels.CountryViewModel
import com.example.practica5_roomdb.ui.theme.Practica5_RoomDBTheme

class MainActivity : ComponentActivity() {

    private val db by lazy {
        Room.databaseBuilder(
            applicationContext,
            CountryDB::class.java,
            "countries.db"
        ).build()
    }
    private val viewModel by viewModels<CountryViewModel>(
        factoryProducer = {
            object : ViewModelProvider.Factory {
                override fun <T : ViewModel> create(modelClass: Class<T>): T {
                    return CountryViewModel(db.countryDao) as T
                }
            }
        }
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Practica5_RoomDBTheme {
                val state by viewModel.state.collectAsState()
                CountryScreen(state = state, onEvent = viewModel::onEvent)
            }
        }
    }
}
