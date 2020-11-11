package com.companytest.thesports.repository.network

import com.companytest.thesports.data.datasource.network.TheSportService
import com.companytest.thesports.domain.ResponseEvent
import com.companytest.thesports.domain.TeamResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface SportService :
    TheSportService {

    @GET("search_all_teams.php")
    override suspend fun retrieveAllTeams(@Query("l") leagueParameter: String): TeamResponse

    @GET("lookupteam.php")
    override suspend fun retrieveTeam(@Query("id") teamId: String): TeamResponse

    @GET("eventsnext.php")
    override suspend fun retrieveAllEventsByTeamId(@Query("id") teamId: String): ResponseEvent
}