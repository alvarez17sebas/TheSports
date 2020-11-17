package com.companytest.thesports

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.companytest.thesports.view.activity.TeamListActivity
import com.companytest.thesports.view.adapter.TeamAdapter
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class TeamListActivityTest {

    @get:Rule
    val activityRule = ActivityScenarioRule(TeamListActivity::class.java)

    @Test
    fun recyclerViewDisplayed() {
        onView(withId(R.id.rvTeamList))
            .check(matches(isDisplayed()))
    }

    @Test
    fun selectedItem() {
        onView(withId(R.id.rvTeamList))
            .perform(actionOnItemAtPosition<TeamAdapter.TeamViewHolder>(0, click()))

        onView(withId(R.id.clContainerDetail))
            .check(matches(isDisplayed()))
    }

}