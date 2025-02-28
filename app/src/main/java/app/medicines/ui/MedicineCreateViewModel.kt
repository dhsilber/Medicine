package app.medicines.ui

import androidx.lifecycle.ViewModel
import app.medicines.data.MedicineRepository

class MedicineCreateViewModel(
    private val medicineRepository: MedicineRepository
) : ViewModel() {
    suspend fun createMedicineFromName(name: String) {

    }

}
