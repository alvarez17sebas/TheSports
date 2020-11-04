package com.companytest.thesports

import com.companytest.thesports.data.Repository
import com.companytest.thesports.domain.Team

import com.companytest.thesports.repository.fake.TeamFakeRepository
import com.companytest.thesports.usecases.RetrieveAllTeams
import com.companytest.thesports.usecases.RetrieveTeam
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Test

class TeamDomainTest {
    @Test
    fun retrieveAllTeams_getAllItems_success() {
        //Arrange
        val fakeRepository: Repository<Team> = TeamFakeRepository()
        val retrieveAllTeams: RetrieveAllTeams = RetrieveAllTeams(fakeRepository)
        val valueExpected: Int = 2

        runBlocking {
            //Act
            val response = retrieveAllTeams.retrieveTeams("Spanish la liga")

            //Assert
            Assert.assertEquals(valueExpected, response.size)
        }
    }

    @Test
    fun retrieveAllTeams_withEmptyParam_failure(){
        //Arrange
        val fakeRepository: Repository<Team> = TeamFakeRepository()
        val retrieveAllTeams: RetrieveAllTeams = RetrieveAllTeams(fakeRepository)
        val valueExpected: Int = 0

        runBlocking {
            //Act
            val response = retrieveAllTeams.retrieveTeams("")

            //Assert
            Assert.assertEquals(valueExpected, response.size)
        }
    }

    @Test
    fun retrieveTeam_withEmptyId_failure(){
        //Arrange
        val fakeRepository: Repository<Team> = TeamFakeRepository()
        val retrieveTeam: RetrieveTeam = RetrieveTeam(fakeRepository)
        val valueExpected: String = ""

        runBlocking {
            //Act
            val response = retrieveTeam.retrieveTeam("")

            //Assert
            Assert.assertEquals(valueExpected, response.idTeam)
        }
    }
}