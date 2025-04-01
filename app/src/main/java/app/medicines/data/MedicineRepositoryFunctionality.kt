package app.medicines.data

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.single

class MedicineRepositoryFunctionality(
    private val medicineDao: MedicineDao
) : MedicineRepository {
    override suspend fun insertMedicine(medicine: Medicine) = medicineDao.insert(medicine)

    override fun getAllMedicinesStream(): Flow<List<Medicine>> = medicineDao.getAll()

//    override fun getById(id: Int): Medicine = medicineDao.getById(id = id).single()
//
//    override suspend fun getByIdFlow(id: Int) = medicineDao.getById(id = id)
}
