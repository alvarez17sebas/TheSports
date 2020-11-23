package com.companytest.thesports.data.league

import com.companytest.thesports.domain.League
import com.companytest.thesports.domain.ResultWrapper
import com.companytest.thesports.domain.repository.LocalLeagueRepository
import com.companytest.thesports.domain.repository.LeagueRemoteRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import javax.inject.Inject

class LeagueRepositoryHandler @Inject constructor(val localLeagueRepository: LocalLeagueRepository, val remoteRepository: LeagueRemoteRepository) {

    private fun toFlowRetrieveAllLeagues(): Flow<List<League>> {
        return flow {
            val response: List<League> = remoteRepository.retrieveAllLeagues()
            localLeagueRepository.saveLeagues(response)
            emit(response)
        }
    }

    fun retrieveAllLeagues(): Flow<ResultWrapper<List<League>>> {
        return localLeagueRepository.getLeagues().flatMapLatest { leagues: List<League> ->
            if(leagues.isNotEmpty()){
                flowOf(leagues)
            }else {
                toFlowRetrieveAllLeagues()
            }
        }.map {leagues: List<League> ->
            val result: ResultWrapper<List<League>> = ResultWrapper.Success(leagues)
            result
        }.onStart {
            emit(ResultWrapper.Loading)
        }.catch {
            emit(ResultWrapper.Error("League error"))
        }.flowOn(Dispatchers.IO)

    }
}