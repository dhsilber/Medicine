package app.medicines

import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.test.assertHasClickAction
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.navigation.compose.ComposeNavigator
import androidx.navigation.testing.TestNavHostController
import app.medicines.testUtilities.MedicineRepositoryFake
import app.medicines.ui.Navigation
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class NavigationTest {
    @get:Rule
    val composeRule = createComposeRule()
    lateinit var navController: TestNavHostController

    @Before
    fun setup() {
        composeRule.setContent {
            navController = TestNavHostController(LocalContext.current)
            navController.navigatorProvider.addNavigator(ComposeNavigator())
            Navigation(
                medicineRepository = MedicineRepositoryFake(),
                navController = navController,
                )
        }
    }

    @Test
    fun `Verify start destination`() {
        composeRule
            .onNodeWithText("Medicines List")
            .assertIsDisplayed()
    }

    @Test
    fun `ListScreen Add button navigates to CreateScreen`() = runTest {
        composeRule
            .onNodeWithContentDescription("Add new medicine")
            .assertIsDisplayed()
            .assertHasClickAction()
            .performClick()

        composeRule
            .onNodeWithText("Add medicine")
            .assertIsDisplayed()
    }

    @Test
    fun `Create cancel button navigates to ListScreen`() = runTest {
        composeRule
            .onNodeWithContentDescription("Add new medicine")
            .performClick()

        composeRule
            .onNodeWithText("Cancel")
            .performClick()

        composeRule
            .onNodeWithContentDescription("Add new medicine")
            .assertIsDisplayed()
    }

    @Test
    fun `Create save button navigates to ListScreen`() = runTest {
        composeRule
            .onNodeWithContentDescription("Add new medicine")
            .performClick()

        composeRule
            .onNodeWithText("Save")
            .performClick()

        composeRule
            .onNodeWithContentDescription("Add new medicine")
            .assertIsDisplayed()
    }
}