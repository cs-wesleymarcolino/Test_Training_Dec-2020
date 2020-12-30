package br.com.concrete.testtrainingdecember

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class LoginActivityTest {
    @get:Rule
    val activityTestRule = ActivityScenarioRule(LoginActivity::class.java)

    @Test
    fun givenInitialState_shouldHaveEmptyEmailAndPassword() {
        onView(withId(R.id.email))
            .check(matches(withText("")))

        onView(withId(R.id.password))
            .check(matches(withText("")))
    }

    @Test
    fun givenEmailIsEmpty_whenLogin_shouldShowEmptyEmailError() {
        // arrange

        // act
        onView(withId(R.id.password))
            .perform(typeText("aA.123232jkh"))
        onView(withId(R.id.login))
            .perform(click())

        // assert
        onView(withText(R.string.error_email_is_empty))
            .check(matches(isDisplayed()))
    }
}