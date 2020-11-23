package com.companytest.thesports.repositoryimpl

import com.companytest.thesports.datasource.network.LeagueService
import com.companytest.thesports.domain.League
import com.companytest.thesports.domain.repository.LeagueRemoteRepository
import javax.inject.Inject

class RemoteRetrofitLeague @Inject constructor(val leagueService: LeagueService) : LeagueRemoteRepository {
    override suspend fun retrieveAllLeagues(): List<League> {
        return leagueService.retrieveAllTeams().leagues
    }
}