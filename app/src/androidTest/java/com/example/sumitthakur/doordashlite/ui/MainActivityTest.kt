package com.example.sumitthakur.doordashlite.ui

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import com.example.sumitthakur.doordashlite.R
import org.junit.Before
import org.junit.Rule
import org.junit.Test

import org.junit.runner.RunWith
import android.content.Intent
import android.support.test.espresso.matcher.ViewMatchers.*
import android.widget.TextView
import org.junit.Assert.assertEquals


@RunWith(AndroidJUnit4::class)
class MainActivityTest {
    val activityTestRule = ActivityTestRule(MainActivity::class.java, true, true)

    @Rule
    fun rule() = activityTestRule

    private var mainActivity: MainActivity? = null

    private var errorText: TextView? = null

    @Before
    fun setUp() {
        mainActivity = activityTestRule.launchActivity(Intent())
        errorText = mainActivity?.findViewById(R.id.error_text) as TextView
    }

    @Test
    fun onSuccess() {
        mainActivity?.onSuccess()
        onView(withId(R.id.fragment_container)).check(matches(isDisplayed()))
    }

    @Test
    fun onError() {
        val expected = mainActivity?.getString(R.string.error_string)
        val actual = errorText?.getText().toString()
        assertEquals("error has been shown",
                expected, actual)
    }
}