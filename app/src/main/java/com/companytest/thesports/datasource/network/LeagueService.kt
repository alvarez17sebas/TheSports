package com.companytest.thesports.datasource.network

import com.companytest.thesports.domain.LeagueResponse
import retrofit2.http.GET

interface LeagueService {
    @GET("all_leagues.php")
    suspend fun retrieveAllTeams(): LeagueResponse
}