package com.companytest.thesports

import com.companytest.thesports.data.Repository
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


    @Before
    fun setup(){
        MockKAnnotations.init(this)
    }

    @Test
    fun retrieveAllTeams_getAllItems_success() {

        //Arrange
        var retrieveAllTeam: RetrieveAllTeams = RetrieveAllTeams(RepositoryHandler(repository))
        var teams: List<Team> = ArrayList()
        val valueExpected = 2

        //Act
        coEvery {
             retrieveAllTeam.retrieveTeams("spanish")
        } returns listOf(Team(), Team())

        runBlocking {
            teams = retrieveAllTeam.retrieveTeams("spanish")
        }

        //Assert
        Assert.assertEquals(valueExpected, teams.size)

    }

    @Test
    fun `retrieveAllItems and to get empty list`(){
        //Arrange
        var retrieveAllTeam: RetrieveAllTeams = RetrieveAllTeams(RepositoryHandler(repository))
        var teams: List<Team> = ArrayList()
        val valueExpected = 0

        //Act
        coEvery {
            retrieveAllTeam.retrieveTeams("spanish")
        } returns listOf()

        runBlocking {
            teams = retrieveAllTeam.retrieveTeams("spanish")
        }

        //Assert
        Assert.assertEquals(valueExpected, teams.size)
    }

    @After
    fun tearDown(){
        unmockkAll()
    }
}