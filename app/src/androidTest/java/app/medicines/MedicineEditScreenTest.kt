package app.medicines

import androidx.compose.ui.test.assertHasClickAction
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.onRoot
import androidx.compose.ui.test.printToLog
import app.medicines.data.Medicine
import app.medicines.ui.MedicineEditScreen
import app.medicines.ui.MedicineEditViewModel
import com.google.common.truth.Truth.assertThat
import io.mockk.every
import io.mockk.mockk
import io.mockk.slot
import junit.framework.TestCase.fail
import kotlinx.coroutines.test.runTest
import org.junit.Rule
import org.junit.Test


class MedicineEditScreenTest {
    @get:Rule
    val composable = createComposeRule()

    @Test
    fun `has buttons`() = runTest {
        val mockViewModel = mockk<MedicineEditViewModel>()
        val medicineIdSlot = slot<Int>()
        val medicine = Medicine(name = "Aspirin", id = 1)

        fail()
//        every { mockViewModel.getById(id = capture(medicineIdSlot)) } returns medicine

        composable.setContent {
            MedicineEditScreen(1, {}, mockViewModel)
        }

        composable
            .onNodeWithText("Cancel")
            .assertIsDisplayed()
            .assertHasClickAction()

        composable
            .onNodeWithText("Save")
            .assertIsDisplayed()
            .assertHasClickAction()

        composable
            .onNodeWithText("Delete")
            .assertIsDisplayed()
            .assertHasClickAction()
    }

    @Test
    fun `Gets medicine object based on id`() = runTest {
        val mockViewModel = mockk<MedicineEditViewModel>()
        val medicineIdSlot = slot<Int>()
        val medicine = Medicine(name = "Aspirin", id = 1)

        fail()
//        every { mockViewModel.getById(id = capture(medicineIdSlot)) } returns medicine

        composable.setContent {
            MedicineEditScreen(1, {}, mockViewModel)
        }

        assertThat(medicineIdSlot.captured).isEqualTo(1)
    }

    @Test
    fun `Displays name of medicine with provided id`() = runTest {
        val mockViewModel = mockk<MedicineEditViewModel>()
        val medicineIdSlot = slot<Int>()
        val testText = "Aspirin"
        val medicine = Medicine(name = testText, id = 1)

        fail()
//        every { mockViewModel.getById(capture(medicineIdSlot)) } returns medicine

        composable.setContent {
            MedicineEditScreen(1, {}, mockViewModel)
        }

        composable
            .onNodeWithText(testText)
            .assertIsDisplayed()

        composable.onRoot(useUnmergedTree = true).printToLog("foo")
    }

}
