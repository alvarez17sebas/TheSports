package com.companytest.thesports.repositoryimpl

import com.companytest.thesports.domain.Team
import com.companytest.thesports.domain.repository.LocalRepository
import com.companytest.thesports.mapping.TeamMapping
import com.companytest.thesports.datasource.database.dao.TeamDao
import com.companytest.thesports.datasource.database.entity.TeamEntity
import javax.inject.Inject

class TeamLocalDatabaseImpl @Inject constructor(var teamDao: TeamDao): LocalRepository<Team> {
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

    override suspend fun getAll(leagueParameter: String): List<Team> {
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