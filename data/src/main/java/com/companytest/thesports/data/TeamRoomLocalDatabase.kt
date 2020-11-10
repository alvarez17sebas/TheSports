package com.companytest.thesports.data

import com.companytest.thesports.data.database.OperationLocalDatabase
import com.companytest.thesports.domain.Team
import com.companytest.thesports.domain.repository.TeamLocalRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import javax.inject.Inject

class TeamRoomLocalDatabase @Inject constructor(var operationLocalDatabase: OperationLocalDatabase<Team>): TeamLocalRepository {
    override suspend fun save(team: Team) {
        operationLocalDatabase.save(team)
    }

    override suspend fun saveAll(teams: List<Team>) {
        operationLocalDatabase.saveAll(teams)
    }

    override suspend fun update(team: Team) {
        operationLocalDatabase.update(team)
    }

    override suspend fun getAll(leagueParameter: String): List<Team> {
        return operationLocalDatabase.getAll()
    }

    override suspend fun getById(id: String): List<Team> {
        return listOf()
    }

    override suspend fun delete(team: Team) {
        operationLocalDatabase.delete(team)

    }

}