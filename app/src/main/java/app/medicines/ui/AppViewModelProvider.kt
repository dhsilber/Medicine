package app.medicines.ui

import android.app.Application
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import app.medicines.MedicinesApplication

/**
 * Provides Factory to create instance of ViewModel for the entire Inventory app
 */
object AppViewModelProvider {
    val Factory = viewModelFactory {

        initializer {
            MedicineListViewModel(
                medicinesApplication().container.medicineRepository,
            )
        }

        initializer {
            MedicineCreateViewModel(medicinesApplication().container.medicineRepository)
        }

        initializer {
            MedicineEditViewModel(
//                this.createSavedStateHandle(),
                medicinesApplication().container.medicineRepository
            )
        }

    }
}

/**
 * Extension function to queries for [Application] object and returns an instance of
 * [MedicinesApplication].
 */
fun CreationExtras.medicinesApplication(): MedicinesApplication =
    (this[AndroidViewModelFactory.APPLICATION_KEY] as MedicinesApplication)
