package com.companytest.thesports

import android.content.Intent
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import com.companytest.thesports.pagepattern.Page
import com.companytest.thesports.pagepattern.TeamDetailPage
import com.companytest.thesports.view.TEAM_ID
import com.companytest.thesports.view.activity.TeamDetailActivity
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
        Page.on<TeamDetailPage>().eventsRecyclerViewIsDisplayed()
    }

    @Test
    fun locateFourthEventItem() {
        startActivity()
        Page.on<TeamDetailPage>().locateEventItem(4)
    }

}