package com.app.universities

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.app.universities.repository.Universities
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.Assert.*
import org.junit.Rule


@RunWith(AndroidJUnit4::class)
class MainActivityUITest {
    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.app.universities", appContext.packageName)
    }

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun greeting_displaysCorrectText() {
        composeTestRule.setContent {
            Greeting(name = "Android")
        }

        // Assert that the greeting message is displayed
        composeTestRule.onNodeWithText("Hello Android!").assertExists()
    }

    @Test
    fun universityListItem_displaysCorrectData() {
        // Create a mock university object
        val university = Universities(
            alphaTwoCode = "US",
            country = "United States",
            domains = listOf("harvard.edu"),
            name = "Harvard University",
            stateProvince = "",
            webPages = listOf("http://www.harvard.edu")
        )

        // Set the Composable to test
        composeTestRule.setContent {
            UniversityListItem(university)
        }

        // Verify that the name and country are displayed
        composeTestRule.onNodeWithText("Harvard University").assertExists()
        composeTestRule.onNodeWithText("United States").assertExists()
    }

}