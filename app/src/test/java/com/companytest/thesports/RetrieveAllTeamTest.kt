package com.companytest.thesports

import com.companytest.thesports.domain.repository.TeamRepository
import com.companytest.thesports.data.TeamRepositoryHandler
import com.companytest.thesports.domain.Team
import com.companytest.thesports.usecases.RetrieveAllTeams
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.unmockkAll
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.single
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class RetrieveAllTeamTest {

    @RelaxedMockK
    lateinit var teamRepository: TeamRepository<Team>
    lateinit var teamRepositoryHandler: TeamRepositoryHandler<Team>

    @Before
    fun setup() {
        MockKAnnotations.init(this)
        teamRepositoryHandler = TeamRepositoryHandler(teamRepository)
    }

    @Test
    fun retrieveAllTeams_getAllItems_success() {

        //Arrange
        val retrieveAllTeam: RetrieveAllTeams = RetrieveAllTeams(TeamRepositoryHandler(teamRepository))
        val parameter: String = ""
        var fakeResponse: Flow<List<Team>> = flowOf(listOf(Team(), Team()))
        val valueExpected = 2
        var response: List<Team>? = null

        //Act
        coEvery {
            teamRepositoryHandler.retrieveAll(parameter)
        } returns fakeResponse

        runBlocking {
            response = retrieveAllTeam.retrieveTeams(parameter).single()
        }

        //Assert
        Assert.assertEquals(valueExpected, response?.size)

    }

    @Test
    fun `retrieveAllItems and to get empty list`() {
        //Arrange
        val retrieveAllTeam: RetrieveAllTeams = RetrieveAllTeams(TeamRepositoryHandler(teamRepository))
        val parameter: String = ""
        var fakeResponse: Flow<List<Team>> = flowOf(ArrayList())
        val valueExpected = 0
        var response: List<Team>? = null

        //Act
        coEvery {
            teamRepositoryHandler.retrieveAll(parameter)
        } returns fakeResponse

        runBlocking {
            response = retrieveAllTeam.retrieveTeams(parameter).single()
        }

        //Assert
        Assert.assertEquals(valueExpected, response?.size)
    }

    @After
    fun tearDown() {
        unmockkAll()
    }
}