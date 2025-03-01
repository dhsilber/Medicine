package app.medicines

import androidx.compose.ui.test.assertHasClickAction
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertTextContains
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.onRoot
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import androidx.compose.ui.test.printToLog
import app.medicines.ui.MedicineCreateScreen
import app.medicines.ui.MedicineCreateViewModel
import com.google.common.truth.Truth.assertThat
import io.mockk.coEvery
import io.mockk.just
import io.mockk.mockk
import io.mockk.runs
import io.mockk.slot
import kotlinx.coroutines.test.runTest
import org.junit.Rule
import org.junit.Test


class MedicineCreateScreenTest {
    @get:Rule
    val composable = createComposeRule()

    @Test
    fun `has buttons`() = runTest {

        val mockViewModel = mockk<MedicineCreateViewModel>()

        composable.setContent {
            MedicineCreateScreen({}, mockViewModel)
        }

        composable
            .onNodeWithText("Cancel")
            .assertIsDisplayed()
            .assertHasClickAction()

        composable
            .onNodeWithText("Save")
            .assertIsDisplayed()
            .assertHasClickAction()
    }

    @Test
    fun `Create click passes text to viewModel create`() = runTest {

        val testText = "Aspirin"

        val mockViewModel = mockk<MedicineCreateViewModel>()

        val medicineNameSlot = slot<String>()
        coEvery { mockViewModel.createMedicineFromName(capture(medicineNameSlot)) } just runs

        composable.setContent {
            MedicineCreateScreen({}, mockViewModel)
        }

        composable
            .onNodeWithText("Add medicine")
            .assertIsDisplayed()

        composable
            .onNodeWithText("Medicine name")
            .assertIsDisplayed()
            .performTextInput(testText)

        composable
            .onNodeWithText("Medicine name")
            .assertTextContains(testText)

        composable
            .onNodeWithText("Save")
            .performClick()

        assertThat(medicineNameSlot.captured).isEqualTo(testText)

        composable.onRoot(useUnmergedTree = true).printToLog("foo")
    }

}
