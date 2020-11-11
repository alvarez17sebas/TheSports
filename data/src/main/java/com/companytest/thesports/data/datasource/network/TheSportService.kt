package com.companytest.thesports.data.datasource.network

import com.companytest.thesports.domain.ResponseEvent
import com.companytest.thesports.domain.TeamResponse

interface TheSportService {
    suspend fun retrieveAllTeams(leagueParameter: String): TeamResponse
    suspend fun retrieveTeam(teamId: String): TeamResponse
    suspend fun retrieveAllEventsByTeamId(teamId: String): ResponseEvent
}