package app.medicines.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import app.medicines.data.MedicineRepository
import app.medicines.data.MedicineRepositoryFunctionality
import kotlinx.serialization.Serializable

@Serializable
object MedicinesList

@Serializable
object MedicineCreate

@Composable
fun Navigation(
    medicineRepository: MedicineRepository,
    navController: NavHostController = rememberNavController(),
) {
    NavHost(
        navController = navController,
        startDestination = MedicinesList,
        modifier = Modifier,
    ) {
        composable<MedicinesList> {
            MedicinesListScreen(
                navigateToCreate = { navController.navigate(route = MedicineCreate) },
                medicineListViewModel = MedicineListViewModel(
                    medicineRepository = medicineRepository
                ),
            )
        }

        composable<MedicineCreate> {
            MedicineCreateScreen(
                navigateToList = { navController.navigate(route = MedicinesList)},
                medicineCreateViewModel = MedicineCreateViewModel(
                    medicineRepository = medicineRepository
                )
            )
        }
    }
}