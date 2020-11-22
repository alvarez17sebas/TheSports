package com.companytest.thesports.pagepattern

import androidx.annotation.IdRes
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import com.companytest.thesports.R
import com.companytest.thesports.view.adapter.EventAdapter

class TeamDetailPage : Page() {
    @IdRes
    val rvEvents: Int = R.id.rvTeamEvents

    fun eventsRecyclerViewIsDisplayed(): Page {
        onView(withId(rvEvents))
            .check(matches(isDisplayed()))
        return this
    }

    fun locateEventItem(position: Int): Page {
        onView(withId(rvEvents))
            .perform(
                RecyclerViewActions.actionOnItemAtPosition<EventAdapter.EventViewHolder>(
                    position,
                    ViewActions.click()
                )
            )

        return this
    }
}