package com.companytest.thesports.domain.repository

import com.companytest.thesports.domain.Team
import kotlinx.coroutines.flow.Flow

interface TeamLocalRepository {
    fun save(team: Team)

    fun saveAll(teams: List<Team>)

    fun update(team: Team)

    fun getAll(leagueParameter: String): Flow<List<Team>>

    fun getById(id: String): Flow<List<Team>>

    fun delete(team: Team)
}