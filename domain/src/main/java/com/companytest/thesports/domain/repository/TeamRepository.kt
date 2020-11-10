package com.companytest.thesports.domain.repository

import com.companytest.thesports.domain.Team
import kotlinx.coroutines.flow.Flow

interface TeamRepository {
    suspend fun retrieveAll(leagueParameter: String): List<Team>
    suspend fun retrieveById(id: String): List<Team>
}