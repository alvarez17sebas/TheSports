package com.companytest.thesports.datasource.network

import com.companytest.thesports.domain.ResponseEvent
import com.companytest.thesports.domain.TeamResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface SportService{

    @GET("search_all_teams.php")
    suspend fun retrieveAllTeams(@Query("l") leagueParameter: String): TeamResponse

    @GET("lookupteam.php")
    suspend fun retrieveTeam(@Query("id") teamId: String): TeamResponse

    @GET("eventsnext.php")
    suspend fun retrieveAllEventsByTeamId(@Query("id") teamId: String): ResponseEvent
}