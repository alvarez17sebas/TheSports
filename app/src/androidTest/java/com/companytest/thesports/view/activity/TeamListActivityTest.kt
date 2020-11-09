package com.companytest.thesports.view.activity

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.companytest.thesports.R
import org.junit.After

import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class TeamListActivityTest {


    @Test
    fun test_isActivityInView() {
        val activityScenario = ActivityScenario.launch(TeamListActivity::class.java)
        onView(withId(R.id.clContainer_teamListActivity))
            .check(matches(isDisplayed()))
    }

    @After
    fun tearDown() {
    }
}