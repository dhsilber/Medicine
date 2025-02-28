package app.medicines

import androidx.compose.ui.test.assertHasClickAction
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.onParent
import androidx.compose.ui.test.onRoot
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.printToLog
import kotlinx.coroutines.test.runTest
import org.junit.Rule
import org.junit.Test

class MedicinesActivityTest {
    @get:Rule
    val composeActivityRule = createAndroidComposeRule<MedicinesActivity>()

    @Test
    fun `list activity Add button navigates to `() = runTest {
        composeActivityRule.onRoot().printToLog("Foo")
        composeActivityRule.onRoot(useUnmergedTree = true).printToLog("Foo")

        val icon = composeActivityRule.onNodeWithContentDescription("Add new medicine")
        icon.assertIsDisplayed()
        icon.assertHasClickAction()
        icon.performClick()
//        val root = composeActivityRule.onRoot(useUnmergedTree = true)
//        icon.onParent().assertHasClickAction()
//        val button = icon.onParent()
//        button.assertHasClickAction()
    }

}
