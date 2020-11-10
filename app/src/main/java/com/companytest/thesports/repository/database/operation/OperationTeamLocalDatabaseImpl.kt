package com.companytest.thesports.repository.database.operation

import com.companytest.thesports.data.database.OperationLocalDatabase
import com.companytest.thesports.domain.Team
import com.companytest.thesports.mapping.TeamMapping
import com.companytest.thesports.repository.database.dao.TeamDao
import com.companytest.thesports.repository.database.entity.TeamEntity
import javax.inject.Inject

class OperationTeamLocalDatabaseImpl @Inject constructor(var teamDao: TeamDao) : OperationLocalDatabase<Team> {
    override suspend fun save(data: Team) {
        val teamEntity: TeamEntity = TeamMapping.toTeamEntity(data)
        teamDao.save(teamEntity)
    }

    override suspend fun saveAll(dataList: List<Team>) {
        val teamsEntity: List<TeamEntity> = TeamMapping.toListTeamEntity(dataList)
        teamDao.saveAll(teamsEntity)
    }

    override suspend fun update(data: Team) {
    }

    override suspend fun getAll(): List<Team> {
        val teamsEntity: List<TeamEntity> = teamDao.getAll()
        return TeamMapping.toListTeamDomain(teamsEntity)
    }

    override suspend fun getById(id: String): List<Team> {
        val teamsEntity: List<TeamEntity> = teamDao.getById(id)
        return TeamMapping.toListTeamDomain(teamsEntity)
    }

    override suspend fun delete(data: Team) {
    }
}