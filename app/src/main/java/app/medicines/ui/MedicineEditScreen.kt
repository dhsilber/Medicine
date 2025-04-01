package app.medicines.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavDestination
import app.medicines.data.Medicine
//import app.medicines.ui.theme.loadMedicineState
import kotlinx.coroutines.launch
import kotlinx.serialization.Serializable

@Serializable
data class MedicineEditDestination(
    val medicineId: Int,
//    val routeName: String = "medicines_edit",
)

@Composable
fun MedicineEditScreen(
    medicineId: Int,
    navigateToList: () -> Unit,
    medicineEditViewModel: MedicineEditViewModel = viewModel(factory = AppViewModelProvider.Factory),
) {
    var medicine: Medicine by remember { mutableStateOf(Medicine()) }
    val coroutineScope = rememberCoroutineScope()

    val localModifier = Modifier.fillMaxSize()

//    val medicine = loadMedicineState(medicineId, medicineEditViewModel).value.getOrNull()

////    lifecycleScope.launch {
//        medicine = medicineEditViewModel.getById(medicineId)
////    }

    Scaffold(
        modifier = localModifier,
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding),
        ) {

            var text: String by remember { mutableStateOf(medicine.name) }

            Text("Add medicine")

            Spacer(Modifier.padding(innerPadding))
            OutlinedTextField(
                value = text,
                onValueChange = { text = it },
                label = { Text("Medicine name") },
                maxLines = 2,
                modifier = Modifier.fillMaxWidth(),
            )
            Spacer(Modifier.padding(innerPadding))
            Row {
                Spacer(Modifier.weight(1f))
                Button(
                    onClick = navigateToList
                ) {
                    Text("Cancel")
                }
                Spacer(Modifier.weight(1f))
                Button(
                    onClick = {
                        coroutineScope.launch {
                            navigateToList()
        //                    (medicineCreateViewModel::createMedicineFromName)(text)
                        }
                    },
        //                    enabled =
                ) {
                    Text("Save")
                }
                Spacer(Modifier.weight(1f))
                Button(
                    onClick = {
                        coroutineScope.launch {
                            navigateToList()
        //                    (medicineCreateViewModel::createMedicineFromName)(text)
                        }
                    },
        //                    enabled =
                ) {
                    Text("Delete")
                }
                Spacer(Modifier.weight(1f))
            }
        }
    }
}