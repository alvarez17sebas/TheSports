package com.companytest.thesports.repository

import com.companytest.thesports.model.BaseTeam
import com.companytest.thesports.model.Event
import com.companytest.thesports.model.Team
import retrofit2.http.GET
import retrofit2.http.Path

interface SportService {

    @GET("search_all_teams.php?l=Spanish la liga")
    suspend fun retrieveAllTeams(): BaseTeam

    @GET("lookupteam.php/{id}")
    suspend fun retrieveTeam(@Path("id") teamId: String): Team

    @GET("eventsnext.php/{id}")
    suspend fun retrieveAllEventsByTeamId(@Path("id") teamId: String): List<Event>
}