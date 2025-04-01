package app.medicines.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.produceState
import app.medicines.data.Medicine
import app.medicines.ui.MedicineEditViewModel

//@Composable
//fun loadMedicineState(
//    medicineId: Int,
//    viewModel: MedicineEditViewModel
////    imageRepository: ImageRepository = ImageRepository()
//): State<Result<Medicine>> {
//    // Creates a State<T> with Result.Loading as initial value
//    // If either `url` or `imageRepository` changes, the running producer
//    // will cancel and will be re-launched with the new inputs.
//    return produceState<Result<Medicine>>(initialValue = Result.success(Medicine()), medicineId, viewModel) {
//        // In a coroutine, can make suspend calls
//        val medicine: Medicine? = viewModel.getById(medicineId)
//
//        // Update State with either an Error or Success result.
//        // This will trigger a recomposition where this State is read
//        value = if (medicine === null) {
//            Result.failure(Exception("No medicine found with id $medicineId."))
//        } else {
//            Result.success(medicine)
//        }
//    }
//}