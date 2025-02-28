package app.medicines.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import app.medicines.data.Medicine
import app.medicines.data.MedicineRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

class MedicineListViewModel(
    private val medicineRepository: MedicineRepository
) : ViewModel() {
    val medicineListUiState: StateFlow<MedicineListUiState> =
        medicineRepository.getAllMedicinesStream().map { MedicineListUiState(it) }
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(TIMEOUT_MILLIS),
                initialValue = MedicineListUiState(),
            )

    companion object {
        private const val TIMEOUT_MILLIS = 5_000L
    }

}

data class MedicineListUiState(val medicineList: List<Medicine> = listOf())
