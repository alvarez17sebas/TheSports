package com.companytest.thesports

import com.companytest.thesports.domain.repository.Repository
import com.companytest.thesports.data.RepositoryHandler
import com.companytest.thesports.domain.Team
import com.companytest.thesports.usecases.RetrieveAllTeams
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.unmockkAll
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class RetrieveAllTeamTest {

    @RelaxedMockK
    lateinit var repository: Repository<Team>
    lateinit var repositoryHandler: RepositoryHandler<Team>

    @Before
    fun setup() {
        MockKAnnotations.init(this)
        repositoryHandler = RepositoryHandler(repository)
    }

    @Test
    fun retrieveAllTeams_getAllItems_success() {

        //Arrange
        val retrieveAllTeam: RetrieveAllTeams = RetrieveAllTeams(RepositoryHandler(repository))
        val parameter: String = ""
        var fakeResponse: List<Team> = listOf(Team(), Team())
        val valueExpected = 2
        var response: List<Team>? = null


        //Act
        coEvery {
            repositoryHandler.retrieveAll(parameter)
        } returns fakeResponse

        runBlocking {
            response = retrieveAllTeam.retrieveTeams(parameter)
        }

        //Assert
        Assert.assertEquals(valueExpected, response?.size)

    }

    @Test
    fun `retrieveAllItems and to get empty list`() {
        //Arrange
        val retrieveAllTeam: RetrieveAllTeams = RetrieveAllTeams(RepositoryHandler(repository))
        val parameter: String = ""
        var fakeResponse: List<Team> = ArrayList()
        val valueExpected = 0
        var response: List<Team>? = null

        //Act
        coEvery {
            repositoryHandler.retrieveAll(parameter)
        } returns fakeResponse

        runBlocking {
            response = retrieveAllTeam.retrieveTeams(parameter)
        }

        //Assert
        Assert.assertEquals(valueExpected, response?.size)
    }

    @After
    fun tearDown() {
        unmockkAll()
    }
}