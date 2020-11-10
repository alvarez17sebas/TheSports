package com.companytest.thesports.data

import com.companytest.thesports.domain.Team
import com.companytest.thesports.domain.repository.TeamRepository
import com.companytest.thesports.domain.repository.TeamLocalRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.withContext
import javax.inject.Inject

class TeamRepositoryHandler @Inject constructor(
    private val remoteTeamRepository: TeamRepository,
    private val localRepository: TeamLocalRepository
) {

    suspend fun retrieveAll(leagueParameter: String): List<Team> {

        var teams: List<Team> = listOf()
        teams = localRepository.getAll(leagueParameter)

        if(teams.isEmpty()){
            teams = remoteTeamRepository.retrieveAll(leagueParameter)
            teams.forEach {
                localRepository.save(it)
            }
        }
        return teams

        /*var teams: List<Team>? = localRepository.getAll(leagueParameter).singleOrNull()

        if (teams == null){
            teams = remoteTeamRepository.retrieveAll(leagueParameter).single()
            teams.forEach {
                localRepository.save(it)
            }
        }*/


        //val flow: Flow<List<Team>> = flowOf(teams)

        /*val flow: Flow<List<Team>> = flow {
            var dataList: List<Team> = localRepository.getAll(leagueParameter).single()
            if (dataList.isEmpty()) {
                dataList = remoteTeamRepository.retrieveAll(leagueParameter).single()
                emit(dataList)
                localRepository.saveAll(dataList)
            }
        }*/
        //return flow
    }

    suspend fun retrieveById(id: String): List<Team> {
        return remoteTeamRepository.retrieveById(id)
    }
}