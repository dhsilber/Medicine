package app.medicines.testUtilities

import app.medicines.data.Medicine
import app.medicines.data.MedicineRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf


class MedicineRepositoryFake : MedicineRepository {
    override suspend fun insertMedicine(medicine: Medicine) {
    }

    override fun getAllMedicinesStream(): Flow<List<Medicine>> {
        return flowOf(listOf(
            Medicine(name = "Medicine One"),
            Medicine(name = "Medicine Two")
        ))
    }

//    override fun getById(id: Int): Flow<Medicine> {
//        TODO("Not yet implemented")
//    }
}
