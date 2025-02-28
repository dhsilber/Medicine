package app.medicines.data

import kotlinx.coroutines.flow.Flow

interface MedicineRepository {
    suspend fun insertMedicine(medicine: Medicine)

    fun getAllMedicinesStream(): Flow<List<Medicine>>
}