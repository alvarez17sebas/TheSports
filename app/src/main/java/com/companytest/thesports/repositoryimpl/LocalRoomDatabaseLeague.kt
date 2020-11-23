package com.companytest.thesports.repositoryimpl

import com.companytest.thesports.datasource.database.dao.LeagueDao
import com.companytest.thesports.domain.League
import com.companytest.thesports.domain.repository.LocalLeagueRepository
import com.companytest.thesports.mapping.LeagueMapping
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class LocalRoomDatabaseLeague @Inject constructor(val leagueDao: LeagueDao) : LocalLeagueRepository{

    override fun saveLeagues(leagues: List<League>) {
        val leaguesEntities = LeagueMapping.toListLeagueEntity(leagues)
        leagueDao.saveAllLeagues(leaguesEntities)
    }

    override fun getLeagues(): Flow<List<League>> {
        return leagueDao.getLeagues().map {
            val leagues: List<League> = LeagueMapping.toListLeagueDomain(it)
            leagues
        }
    }
}