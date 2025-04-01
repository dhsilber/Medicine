package app.medicines.ui

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import androidx.navigation.toRoute
import app.medicines.data.Medicine
import app.medicines.data.MedicineRepository
import kotlinx.serialization.Serializable

@Serializable
object MedicinesList

@Serializable
object MedicineCreate

//@Serializable
//data class MedicineEdit(val medicineId: Int)

@Composable
fun Navigation(
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
                navigateToEdit = { medicineId: Int -> navController.navigate(route = MedicineEditDestination(medicineId)) },
            )
        }

        composable<MedicineCreate> {
            MedicineCreateScreen(
                navigateToList = { navController.navigate(route = MedicinesList)},
            )
        }

        composable<MedicineEditDestination>
//        (
//            route = MedicineEditDestination.routeWithArgs,
//            arguments = listOf(navArgument(MedicineEditDestination.medicineIdArg) {
//                type = NavType.IntType
//            })
//        )
        { backStackEntry ->
            val route: MedicineEditDestination = backStackEntry.toRoute()
            Log.d("app.medicine", "route: (${route.medicineId}) $route")
            Log.d("app.medicine", "navigation route: $MedicinesList")
            MedicineEditScreen(
                medicineId = route.medicineId,
                navigateToList = { navController.navigate(route = MedicinesList)},
            )
        }
    }
}