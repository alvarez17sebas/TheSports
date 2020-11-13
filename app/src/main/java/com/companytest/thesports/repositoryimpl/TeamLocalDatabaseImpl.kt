package com.companytest.thesports.repositoryimpl

import com.companytest.thesports.domain.Team
import com.companytest.thesports.domain.repository.LocalRepository
import com.companytest.thesports.mapping.TeamMapping
import com.companytest.thesports.datasource.database.dao.TeamDao
import com.companytest.thesports.datasource.database.entity.TeamEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class TeamLocalDatabaseImpl @Inject constructor(var teamDao: TeamDao) : LocalRepository<Team> {
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

    override fun getAll(leagueParameter: String): Flow<List<Team>> {
        return teamDao.getAll().map {
            TeamMapping.toListTeamDomain(it)
        }
    }

    override fun getById(id: String): Flow<List<Team>> {
        return teamDao.getById(id).map {
            TeamMapping.toListTeamDomain(it)
        }
    }

    override suspend fun delete(data: Team) {
    }

}