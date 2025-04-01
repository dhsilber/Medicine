package app.medicines

import androidx.compose.ui.test.assertHasClickAction
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import app.medicines.testUtilities.MedicineRepositoryFake
import app.medicines.ui.Navigation
import junit.framework.TestCase.fail
import kotlinx.coroutines.test.runTest
import org.junit.Rule
import org.junit.Test

class MedicinesListScreenTest {
    @get:Rule
    val composable = createComposeRule()

    @Test
    fun `Add button is displayed`() = runTest {

        fail()
        composable.setContent {
//            Navigation(medicineRepository = MedicineRepositoryFake())
        }

        composable
            .onNodeWithContentDescription("Add new medicine")
            .assertIsDisplayed()
            .assertHasClickAction()
    }

    @Test
    fun `List of medicines is displayed`() = runTest {

        fail()
        composable.setContent {
//            Navigation(medicineRepository = MedicineRepositoryFake())
        }

        composable
            .onNodeWithText("Medicine One")
            .assertIsDisplayed()

        composable
            .onNodeWithText("Medicine Two")
            .assertIsDisplayed()
//            .assertHasClickAction()
//            .performClick()
    }

    @Test
    fun `Tapping on a medicine navigates to edit screen`() = runTest {

        fail()
        composable.setContent {
//            Navigation(medicineRepository = MedicineRepositoryFake())
        }

        composable
            .onNodeWithText("Medicine Two")
            .assertIsDisplayed()
            .assertHasClickAction()
            .performClick()
    }

}
