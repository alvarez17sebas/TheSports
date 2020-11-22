package com.companytest.thesports.pagepattern

import androidx.annotation.IdRes
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import com.companytest.thesports.R
import com.companytest.thesports.view.adapter.TeamAdapter

class TeamListPage : Page() {

    @IdRes
    val rvItems: Int = R.id.rvTeamList
    @IdRes
    val mainContainerOtherView: Int =
        R.id.clContainerDetail

    fun checkIfRecycleViewIsDisplayed(): Page {
        onView(withId((rvItems)))
            .check(matches(isDisplayed()))

        return this
    }

    fun selectRecyclerViewItem(position: Int): Page {
        onView(withId(rvItems))
            .perform(
                actionOnItemAtPosition<TeamAdapter.TeamViewHolder>(
                    position,
                    click()
                )
            )

        onView(withId(mainContainerOtherView))
            .check(matches(isDisplayed()))

        return this
    }

}