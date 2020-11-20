package com.companytest.thesports

import com.companytest.thesports.data.TeamRepositoryHandler
import com.companytest.thesports.domain.ResultWrapper
import com.companytest.thesports.domain.Team
import com.companytest.thesports.domain.repository.LocalRepository
import com.companytest.thesports.domain.repository.RemoteRepository
import com.companytest.thesports.fake.FakeTeamEmptyDataLocalRepository
import com.companytest.thesports.fake.FakeTeamEmptyDataRemoteRepository
import com.companytest.thesports.fake.FakeTeamFullDataLocalRepository
import com.companytest.thesports.fake.FakeTeamFullDataRemoteRepository
import com.companytest.thesports.usecases.RetrieveAllTeams
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class RetrieveAllTeamTest {
    
    @Before
    fun setup() {
    }

   @Test
    fun retrieveAllTeams_toGetStateSuccessful_Successful() {
        //Arrange
        val teamRemoteRepository: RemoteRepository<Team> = FakeTeamFullDataRemoteRepository()
        val localRepository: LocalRepository<Team> = FakeTeamFullDataLocalRepository()
        var teamRepositoryHandler: TeamRepositoryHandler = TeamRepositoryHandler(localRepository, teamRemoteRepository)

        val retrieveTeamsUseCase: RetrieveAllTeams = RetrieveAllTeams(teamRepositoryHandler)
        val parameter = ""

        //Act
        val response: Flow<ResultWrapper<List<Team>>> = retrieveTeamsUseCase.retrieveTeams(parameter)

        //Assert
        runBlocking {
            response.collect {value: ResultWrapper<List<Team>> ->
                when(value) {
                    is ResultWrapper.Loading -> {Assert.assertEquals(ResultWrapper.Loading, value)}
                    is ResultWrapper.Success -> { assert(value is ResultWrapper.Success)}
                    is ResultWrapper.Error -> {Assert.assertEquals(ResultWrapper.Error(""), value)}
                }
            }
        }
    }

    @Test
    fun retrieveAllTeams_toGetAllData_successful() {
        //Arrange
        val teamRemoteRepository: RemoteRepository<Team> = FakeTeamFullDataRemoteRepository()
        val localRepository: LocalRepository<Team> = FakeTeamFullDataLocalRepository()
        var teamRepositoryHandler: TeamRepositoryHandler = TeamRepositoryHandler(localRepository, teamRemoteRepository)

        val retrieveTeamsUseCase: RetrieveAllTeams = RetrieveAllTeams(teamRepositoryHandler)
        val expectedValue = listOf(Team("1", "Team One"), Team("2", "Team Two"))
        val parameter = ""

        //Act
        var response: Flow<ResultWrapper<List<Team>>> = retrieveTeamsUseCase.retrieveTeams(parameter)

        //Assert
        runBlocking {
            response.collect{ value: ResultWrapper<List<Team>> ->
                when(value) {
                    is ResultWrapper.Loading -> {Assert.assertEquals(ResultWrapper.Loading, value)}
                    is ResultWrapper.Success -> {Assert.assertEquals(expectedValue, value.data)}
                    is ResultWrapper.Error -> {Assert.assertEquals(ResultWrapper.Error(""), value)}
                }
            }
        }
    }

    @Test
    fun retrieveAllTeams_toGetEmptyData_successful() {
        //Arrange
        val teamRemoteRepository: RemoteRepository<Team> = FakeTeamEmptyDataRemoteRepository()
        val localRepository: LocalRepository<Team> = FakeTeamEmptyDataLocalRepository()
        var teamRepositoryHandler: TeamRepositoryHandler = TeamRepositoryHandler(localRepository, teamRemoteRepository)
        val retrieveTeamsUseCase: RetrieveAllTeams = RetrieveAllTeams(teamRepositoryHandler)
        val expectedValue = listOf<Team>()
        val parameter = ""

        //Act
        var response: Flow<ResultWrapper<List<Team>>> = retrieveTeamsUseCase.retrieveTeams(parameter)

        //Assert
        runBlocking {
            response.collect{ value: ResultWrapper<List<Team>> ->
                when(value) {
                    is ResultWrapper.Loading -> {Assert.assertEquals(ResultWrapper.Loading, value)}
                    is ResultWrapper.Success -> {Assert.assertEquals(expectedValue, value.data)}
                    is ResultWrapper.Error -> {Assert.assertEquals(ResultWrapper.Error(""), value)}
                }
            }
        }
    }

    @After
    fun tearDown() {
    }
}