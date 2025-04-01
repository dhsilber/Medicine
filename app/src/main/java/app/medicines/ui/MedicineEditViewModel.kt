package app.medicines.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import app.medicines.data.Constants.TIMEOUT_MILLIS
import app.medicines.data.Medicine
import app.medicines.data.MedicineRepository
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.single
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class MedicineEditViewModel(
//    savedStateHandle: SavedStateHandle,
    private val medicineRepository: MedicineRepository
) : ViewModel() {

//    private var medicineEditUiState: SharedFlow<MedicineEditUiState> =


//    var medicineState by mutableStateOf(Medicine())
//        private set
//
//    init {
//        viewModelScope.launch {
//            medicineState = medicineRepository.getById(medicineId)
//                .filterNotNull()
//                .first()
//        }
//    }

//    private val medicineId: Int = checkNotNull(savedStateHandle[MedicineEditDestination.routeWithArgs])

//    suspend fun createMedicineFromName(name: String) {
//        val medicine = Medicine(name = name)
//
//        medicineRepository.insertMedicine(medicine = medicine)
//    }

//    fun getById(id: Int) : Medicine? {
//        viewModelScope.launch {
//            try {
//                val data = medicineRepository.getById(id)
//            }
//        }
//            return medicineRepository.getById(id)
////                .filterNotNull()
//                .first()
//    }

//        fun getById(id: Int): Medicine = medicineRepository.getById(id)
}

data class MedicineEditUiState( val medicine: Medicine = Medicine() )
