package com.companytest.thesports.data

import com.companytest.thesports.data.database.OperationLocalDatabase
import com.companytest.thesports.domain.Team
import com.companytest.thesports.domain.repository.Repository
import com.companytest.thesports.domain.repository.TeamLocalRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import javax.inject.Inject

class TeamRoomLocalDatabase @Inject constructor(var operationLocalDatabase: OperationLocalDatabase<Team>): TeamLocalRepository {
    override fun save(team: Team) {

    }

    override fun saveAll(teams: List<Team>) {

    }

    override fun update(team: Team) {

    }

    override fun getAll(leagueParameter: String): Flow<List<Team>> {
        return flowOf()
    }

    override fun getById(id: String): Flow<List<Team>> {
        return flowOf()
    }

    override fun delete(team: Team) {

    }

}