package com.companytest.thesports

import com.companytest.thesports.domain.repository.TeamRepository
import com.companytest.thesports.data.handler.TeamRepositoryHandler
import com.companytest.thesports.domain.Team
import com.companytest.thesports.usecases.RetrieveTeam
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.unmockkAll
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class RetrieveTeamTest {

    @RelaxedMockK
    lateinit var teamRepository: TeamRepository
    lateinit var teamRepositoryHandler: TeamRepositoryHandler

    @Before
    fun setup() {
        MockKAnnotations.init(this)
        teamRepositoryHandler =
            TeamRepositoryHandler(
                teamRepository
            )
    }

    @Test
    fun `retrieveTeam return team object success`() {
        //Arrange
        val retrieveTeam: RetrieveTeam = RetrieveTeam(teamRepository)
        val param: String = ""
        var fakeResponse: Flow<List<Team>> = flowOf(listOf(Team()))
        val expectedValue: Team = Team()
        var response: Team? = null

        //Act
        coEvery {
            teamRepositoryHandler.retrieveById(param)
        } returns fakeResponse

        runBlocking {
            response = retrieveTeam.retrieveTeam(param).single()
        }

        //Assert
        Assert.assertEquals(expectedValue, response)
    }

    @After
    fun tearDown() {
        unmockkAll()
    }
}