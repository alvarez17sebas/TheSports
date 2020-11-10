package com.companytest.thesports.repository.database

import com.companytest.thesports.data.database.OperationLocalDatabase
import com.companytest.thesports.domain.Team
import com.companytest.thesports.mapping.TeamMapping
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import javax.inject.Inject

class OperationTeamLocalDatabaseImpl @Inject constructor(var teamDao: TeamDao) : OperationLocalDatabase<Team> {
    override fun save(data: Team) {
        val teamEntity: TeamEntity = TeamMapping.toTeamEntity(data)
        teamDao.save(teamEntity)
    }

    override fun saveAll(dataList: List<Team>) {
    }

    override fun update(data: Team) {
    }

    override fun getAll(): Flow<List<Team>> {
        return flowOf()
    }

    override fun getById(id: String): Flow<List<Team>> {
        return flowOf()
    }

    override fun delete(data: Team) {
    }
}