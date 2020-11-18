package com.companytest.thesports

import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.companytest.thesports.pagepattern.Page
import com.companytest.thesports.pagepattern.TeamListPage
import com.companytest.thesports.view.activity.TeamListActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class TeamListActivityTest {

    @get:Rule
    val activityRule = ActivityScenarioRule(TeamListActivity::class.java)

    @Test
    fun recyclerViewDisplayed() {
        Page.on<TeamListPage>().checkIfRecycleViewIsDisplayed()
    }

    @Test
    fun selectedItem() {
        Page.on<TeamListPage>().selectRecyclerViewItem(0)
    }

}