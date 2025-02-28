package app.medicines.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.heading
import androidx.compose.ui.semantics.semantics

@Composable
fun MedicinesListScreen(
    navigateToCreate: () -> Unit,
    medicineListViewModel: MedicineListViewModel,
) {
    val medicineListUiState by medicineListViewModel.medicineListUiState.collectAsState()

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        floatingActionButton = {
            FloatingActionButton(
                onClick = navigateToCreate,
                content = {
                    Icon(Icons.Default.Add, contentDescription = "Add new medicine")
                }
            )
        }
    ) { innerPadding ->
        Text("Medicines List",
            modifier = Modifier
                .semantics { heading() }
                .padding(innerPadding),
        )
        LazyColumn {
            items(
                items = medicineListUiState.medicineList,
                key = null,
            ) {
                medicine ->
                Text(medicine.name)
            }
        }
    }

}
