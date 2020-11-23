package com.companytest.thesports

import com.companytest.thesports.data.team.TeamRepositoryHandler
import com.companytest.thesports.domain.ResultWrapper
import com.companytest.thesports.domain.Team
import com.companytest.thesports.usecases.RetrieveAllTeams
import io.mockk.every
import io.mockk.mockk
import io.mockk.unmockkAll
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class RetrieveAllTeamTest {

    //Full data test
    private val repositoryHandlerFullData: TeamRepositoryHandler = mockk()
    private val fullDataFlow = flowOf(ResultWrapper.Success(listOf(Team("1", "Team One"), Team("2", "Team Two"))))

    //Empty data test
    private val repositoryHandlerEmptyData: TeamRepositoryHandler = mockk()
    private val emptyDataFlow = flowOf(ResultWrapper.Success(emptyList<Team>()))

    @Before
    fun setup() {
        every {
            repositoryHandlerFullData.retrieveAll("")
        } returns fullDataFlow

        every {
            repositoryHandlerEmptyData.retrieveAll("")
        } returns emptyDataFlow
    }

    @Test
    fun retrieveAllTeams_toGetStateSuccessful_Successful() {
        //Arrange
        val retrieveTeamsUseCase: RetrieveAllTeams = RetrieveAllTeams(repositoryHandlerFullData)
        val parameter = ""

        //Act
        val response: Flow<ResultWrapper<List<Team>>> =
            retrieveTeamsUseCase.retrieveTeams(parameter)

        //Assert
        runBlocking {
            response.collect { value: ResultWrapper<List<Team>> ->
                when (value) {
                    is ResultWrapper.Loading -> {
                        Assert.assertEquals(ResultWrapper.Loading, value)
                    }
                    is ResultWrapper.Success -> {
                        assert(value is ResultWrapper.Success)
                    }
                    is ResultWrapper.Error -> {
                        Assert.assertEquals(ResultWrapper.Error(""), value)
                    }
                }
            }
        }
    }

    @Test
    fun retrieveAllTeams_toGetAllData_successful() {
        //Arrange
        val retrieveTeamsUseCase: RetrieveAllTeams = RetrieveAllTeams(repositoryHandlerFullData)
        val expectedValue = listOf(Team("1", "Team One"), Team("2", "Team Two"))
        val parameter = ""

        //Act
        var response: Flow<ResultWrapper<List<Team>>> =
            retrieveTeamsUseCase.retrieveTeams(parameter)

        //Assert
        runBlocking {
            response.collect { value: ResultWrapper<List<Team>> ->
                when (value) {
                    is ResultWrapper.Loading -> {
                        Assert.assertEquals(ResultWrapper.Loading, value)
                    }
                    is ResultWrapper.Success -> {
                        Assert.assertEquals(expectedValue, value.data)
                    }
                    is ResultWrapper.Error -> {
                        Assert.assertEquals(ResultWrapper.Error(""), value)
                    }
                }
            }
        }
    }

    @Test
    fun retrieveAllTeams_toGetEmptyData_successful() {
        //Arrange
        val retrieveTeamsUseCaseMock = RetrieveAllTeams(repositoryHandlerEmptyData)
        val expectedValue = listOf<Team>()
        val parameter = ""

        //Act
        var response: Flow<ResultWrapper<List<Team>>> =
            retrieveTeamsUseCaseMock.retrieveTeams(parameter)

        //Assert
        runBlocking {
            response.collect { value: ResultWrapper<List<Team>> ->
                when (value) {
                    is ResultWrapper.Loading -> {
                        Assert.assertEquals(ResultWrapper.Loading, value)
                    }
                    is ResultWrapper.Success -> {
                        Assert.assertEquals(expectedValue, value.data)
                    }
                    is ResultWrapper.Error -> {
                        Assert.assertEquals(ResultWrapper.Error(""), value)
                    }
                }
            }
        }
    }

    @After
    fun tearDown() {
        unmockkAll()
    }
}