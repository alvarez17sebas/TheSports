package com.companytest.thesports.domain.repository

import com.companytest.thesports.domain.Team
import kotlinx.coroutines.flow.Flow

interface TeamLocalRepository {
    suspend fun save(team: Team)

    suspend fun saveAll(teams: List<Team>)

    suspend fun update(team: Team)

    suspend fun getAll(leagueParameter: String): List<Team>

    suspend fun getById(id: String): List<Team>

    suspend fun delete(team: Team)
}