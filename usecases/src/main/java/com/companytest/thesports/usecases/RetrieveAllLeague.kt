package com.companytest.thesports.usecases

import com.companytest.thesports.data.league.LeagueRepositoryHandler
import com.companytest.thesports.domain.League
import com.companytest.thesports.domain.ResultWrapper
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class RetrieveAllLeague @Inject constructor(val repositoryHandler: LeagueRepositoryHandler) {
    fun retrieveAllLeagues(): Flow<ResultWrapper<List<League>>>{
        return repositoryHandler.retrieveAllLeagues()
    }
}