package com.finite.day03practise

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Rule

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.finite.day03practise", appContext.packageName)
    }
}

@RunWith(AndroidJUnit4::class)
class CalculatorTests {

    @get:Rule()
    val activity = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun calculate_default_tip() {
        onView(withId(R.id.tipValue)).perform(typeText("50.00"))
        onView(withId(R.id.button)).perform(click())
        onView(withId(R.id.newTip)).check(matches(withText("Tip Amount : Rs. 10.0")))
    }

    @Test
    fun calculate_second_tip() {
        onView(withId(R.id.tipValue)).perform(typeText("50.00"))
        onView(withId(R.id.good)).perform(click())
        onView(withId(R.id.button)).perform(click())
        onView(withId(R.id.newTip)).check(matches(withText("Tip Amount : Rs. 7.5")))
    }

    @Test
    fun calculate_third_tip() {
        onView(withId(R.id.tipValue)).perform(typeText("50.00"))
        onView(withId(R.id.okay)).perform(click())
        onView(withId(R.id.button)).perform(click())
        onView(withId(R.id.newTip)).check(matches(withText("Tip Amount : Rs. 5.0")))
    }

}