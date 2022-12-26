package com.github.felipecastilhos.pokedexandroid

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import com.github.felipecastilhos.pokedexandroid.core.ui.theme.PokedexAndroidTheme
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@LargeTest
@HiltAndroidTest
class AppNavigationTest {
    @get:Rule(order = 0)
    var hiltTestRule = HiltAndroidRule(this)

    @get:Rule(order = 1)
    var composeTestRule = createAndroidComposeRule<HiltTestActivity>()

    @Before
    fun init() {
        hiltTestRule.inject()
    }

    @Test
    fun search_screen() {
        setContent()
        composeTestRule.onNodeWithText("Bulbassauro").assertIsDisplayed()
    }

    @Test
    fun search_screen_navigate_to_pokemon_detail() {
        setContent()
        composeTestRule.onNodeWithText("Bulbassauro").performClick()
        composeTestRule.onNodeWithText("Some details here").assertIsDisplayed()
    }

    private fun setContent() {
        composeTestRule.setContent {
            PokedexAndroidTheme {
                PokemonNavGraph()
            }
        }
    }
}
