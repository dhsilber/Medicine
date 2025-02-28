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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import kotlinx.coroutines.launch

@Composable
fun MedicineCreateScreen(
    navigateToList: () -> Unit,
    medicineCreateViewModel: MedicineCreateViewModel,
) {
    val coroutineScope = rememberCoroutineScope()

    val localModifier = Modifier.fillMaxSize()

    Scaffold(
        modifier = localModifier,
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding),
        ) {
            var text by remember { mutableStateOf("") }

            Text("Add medicine")

            Spacer(Modifier.padding(innerPadding))
            OutlinedTextField(
                value = text,
                onValueChange = { text = it },
                label = { Text("Medicine name")},
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
                            (medicineCreateViewModel::createMedicineFromName)(text)
//                            onDoneButtonClicked()
                        }
                    },
//                    enabled =
                ) {
                    Text("Save")
                }
                Spacer(Modifier.weight(1f))
            }
        }
    }
}