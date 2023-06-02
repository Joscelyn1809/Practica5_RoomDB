package com.example.practica5_roomdb

import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.practica5_roomdb.data.room.events.CountryEvent
import com.example.practica5_roomdb.data.room.CountryState
import com.example.practica5_roomdb.data.room.sorts.SortType

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CountryScreen(
    state: CountryState, onEvent: (CountryEvent) -> Unit
) {
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = {
                onEvent(CountryEvent.ShowDialog)
            }) {
                Icon(
                    imageVector = Icons.Default.Add, contentDescription = "Add country"
                )
            }
        }, modifier = Modifier.padding(16.dp)
    ) { padding ->

        if (state.isAddingCountry) {
            AddCountryDialog(state, onEvent)
        }

        LazyColumn(
            contentPadding = padding,
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            item {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .horizontalScroll(rememberScrollState()),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    SortType.values().forEach { sortType ->
                        Row(
                            modifier = Modifier.clickable {
                                    onEvent(CountryEvent.SortCountries(sortType))
                                }, verticalAlignment = CenterVertically
                        ) {
                            RadioButton(selected = state.sortType == sortType, onClick = {
                                onEvent(CountryEvent.SortCountries(sortType))
                            })
                            Text(text = sortType.name)
                        }
                    }
                }
            }
            items(state.countries) { country ->
                Row(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column(modifier = Modifier.weight(1f)) {
                        Text(
                            text = "${country.countryName}, ${country.countryContinent}",
                            fontSize = 20.sp
                        )
                    }
                    IconButton(onClick = {
                        onEvent(CountryEvent.DeleteCountry(country))
                    }) {
                        Icon(
                            imageVector = Icons.Default.Delete,
                            contentDescription = "Delete country"
                        )
                    }
                }
            }
        }
    }
}