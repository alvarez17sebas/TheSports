package com.companytest.thesports.repository.real

import com.companytest.thesports.model.BaseEvent
import com.companytest.thesports.model.BaseTeam
import com.companytest.thesports.model.Event
import com.companytest.thesports.model.Team
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface SportService {

    @GET("search_all_teams.php")
    suspend fun retrieveAllTeams(@Query("l") leagueParameter: String): BaseTeam

    @GET("lookupteam.php")
    suspend fun retrieveTeam(@Query("id") teamId: String): BaseTeam

    @GET("eventsnext.php")
    suspend fun retrieveAllEventsByTeamId(@Query("id") teamId: String): BaseEvent
}