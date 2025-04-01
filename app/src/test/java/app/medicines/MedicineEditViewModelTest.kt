package app.medicines

import app.medicines.data.MedicineRepositoryFunctionality
import app.medicines.ui.MedicineEditViewModel
import io.mockk.mockk
import org.junit.Test

class MedicineEditViewModelTest {
    @Test
    fun `findById when Find Medicine by id`() {
        val mockMedicineRepository = mockk<MedicineRepositoryFunctionality>()
        val viewModel = MedicineEditViewModel(
            medicineRepository = mockMedicineRepository
        )
//        val mockRepository = mockk(MedicineRepository)
//        val viewModel = MedicineCreateViewModel()
    }
}