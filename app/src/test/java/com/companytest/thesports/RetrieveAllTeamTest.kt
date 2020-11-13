package com.companytest.thesports

import com.companytest.thesports.data.TeamRepositoryHandler
import com.companytest.thesports.domain.Team
import com.companytest.thesports.domain.repository.LocalRepository
import com.companytest.thesports.domain.repository.RemoteRepository
import com.companytest.thesports.usecases.RetrieveAllTeams
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.unmockkAll
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class RetrieveAllTeamTest {

    @RelaxedMockK
    lateinit var teamRemoteRepository: RemoteRepository<Team>
    @RelaxedMockK
    lateinit var localRepository: LocalRepository<Team>
    lateinit var teamRepositoryHandler: TeamRepositoryHandler

    @Before
    fun setup() {
        MockKAnnotations.init(this)
        teamRepositoryHandler =
            TeamRepositoryHandler(
                localRepository,
                teamRemoteRepository
            )
    }

    @Test
    fun retrieveAllTeams_getAllItems_success() {

        //Arrange
        val retrieveAllTeam: RetrieveAllTeams = RetrieveAllTeams(teamRepositoryHandler)
        val parameter: String = ""
        var fakeResponse: Flow<List<Team>> = flowOf(listOf(Team(), Team()))
        val valueExpected = 2
        var response: List<Team>? = null

        //Act
        coEvery {
            teamRepositoryHandler.retrieveAll(parameter)
        } returns fakeResponse

        fakeResponse.map {
            val a = ""
        }

        runBlocking {
            response = retrieveAllTeam.retrieveTeams(parameter).single()
        }

        //Assert
        Assert.assertEquals(valueExpected, response?.size)

    }

    @Test
    fun `retrieveAllItems and to get empty list`() {
        //Arrange
        val retrieveAllTeam: RetrieveAllTeams = RetrieveAllTeams(teamRepositoryHandler)
        val parameter: String = ""
        var fakeResponse: Flow<List<Team>> = flowOf(listOf())
        val valueExpected = 0
        var response: List<Team>? = null

        //Act
        coEvery {
            teamRepositoryHandler.retrieveAll(parameter)
        } returns fakeResponse

        runBlocking {
           retrieveAllTeam.retrieveTeams(parameter).collect {
                val a = ""
            }
        }

        //Assert
        Assert.assertEquals(valueExpected, response?.size)
    }

    @After
    fun tearDown() {
        unmockkAll()
    }
}