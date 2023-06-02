package com.example.practica5_roomdb

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.practica5_roomdb.data.room.events.CountryEvent
import com.example.practica5_roomdb.data.room.CountryState

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddCountryDialog(
    state: CountryState,
    onEvent: (CountryEvent) -> Unit,
    modifier: Modifier = Modifier
) {
    AlertDialog(
        modifier = modifier,
        onDismissRequest = { onEvent(CountryEvent.HideDialog) },
        title = { Text(text = "Añadir país") },
        text = {
            Column(
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                TextField(
                    value = state.countryName,
                    onValueChange = {
                        onEvent(CountryEvent.SetCountryName(it))
                    },
                    placeholder = {
                        Text(text = "País")
                    }
                )

                TextField(
                    value = state.countryContinent,
                    onValueChange = {
                        onEvent(CountryEvent.SetCountryContinent(it))
                    },
                    placeholder = {
                        Text(text = "Continente")
                    }
                )
            }
        },
        confirmButton = {
            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                Button(onClick = {
                    onEvent(CountryEvent.SaveCountry)
                }) {
                    Text(text = "Guardar")
                }
            }
        }
    )
}