package app.medicines.data

import kotlinx.coroutines.flow.Flow

interface MedicineRepository {
    suspend fun insertMedicine(medicine: Medicine)

    fun getAllMedicinesStream() : Flow<List<Medicine>>


//    fun getById(id: Int): Medicine
//
//    suspend fun getByIdFlow(id: Int): Flow<Medicine>
}