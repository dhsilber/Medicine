package app.medicines.data

import kotlinx.coroutines.flow.Flow

class MedicineRepositoryFunctionality(
    private val medicineDao: MedicineDao
) : MedicineRepository {
    override suspend fun insertMedicine(medicine: Medicine) {
        TODO("Not yet implemented")
    }

    override fun getAllMedicinesStream(): Flow<List<Medicine>> = medicineDao.getAll()
}
