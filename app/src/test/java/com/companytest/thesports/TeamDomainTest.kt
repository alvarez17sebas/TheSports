package com.companytest.thesports

import com.companytest.thesports.domain.TeamDomain
import com.companytest.thesports.model.Team
import com.companytest.thesports.repository.RemoteRepository
import com.companytest.thesports.repository.fake.TeamFakeRepository
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Test

class TeamDomainTest {
    @Test
    fun retrieveAllTeams_getAllItems_success() {
        //Arrange
        val fakeRepository: RemoteRepository<Team> = TeamFakeRepository()
        val teamDomain: TeamDomain = TeamDomain(fakeRepository)
        val valueExpected: Int = 2

        runBlocking {
            //Act
            val response = teamDomain.retrieveAllTeams("Spanish la liga")

            //Assert
            Assert.assertEquals(valueExpected, response.size)
        }
    }

    @Test
    fun retrieveAllTeams_withEmptyParam_failure(){
        //Arrange
        val fakeRepository: RemoteRepository<Team> = TeamFakeRepository()
        val teamDomain: TeamDomain = TeamDomain(fakeRepository)
        val valueExpected: Int = 0

        runBlocking {
            //Act
            val response = teamDomain.retrieveAllTeams("")

            //Assert
            Assert.assertEquals(valueExpected, response.size)
        }
    }

    @Test
    fun retrieveTeam_withEmptyId_failure(){
        //Arrange
        val fakeRepository: RemoteRepository<Team> = TeamFakeRepository()
        val teamDomain: TeamDomain = TeamDomain(fakeRepository)
        val valueExpected: String = ""

        runBlocking {
            //Act
            val response = teamDomain.retrieveTeam("")

            //Assert
            Assert.assertEquals(valueExpected, response.idTeam)
        }
    }
}