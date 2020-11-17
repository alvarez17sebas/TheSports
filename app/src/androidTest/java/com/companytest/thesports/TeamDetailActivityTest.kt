package com.companytest.thesports

import android.content.Intent
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import com.companytest.thesports.view.TEAM_ID
import com.companytest.thesports.view.activity.TeamDetailActivity
import com.companytest.thesports.view.adapter.EventAdapter
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class TeamDetailActivityTest {

    @get:Rule
    val activityRule = ActivityTestRule(TeamDetailActivity::class.java, true, false)

    private fun startActivity() {
        var intent: Intent = Intent()
        intent.putExtra(TEAM_ID, "134221")
        activityRule.launchActivity(intent)
    }

    @Test
    fun eventsRecyclerViewIsDisplayed() {
        startActivity()
        onView(withId(R.id.rvTeamEvents))
            .check(matches(isDisplayed()))
    }

    @Test
    fun locateFourthEventItem() {
        startActivity()
        onView(withId(R.id.rvTeamEvents))
            .perform(
                RecyclerViewActions.actionOnItemAtPosition<EventAdapter.EventViewHolder>(
                    4,
                    ViewActions.click()
                )
            )
    }

}