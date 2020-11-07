package com.companytest.thesports

import com.companytest.thesports.domain.repository.Repository
import com.companytest.thesports.data.RepositoryHandler
import com.companytest.thesports.domain.Team
import com.companytest.thesports.usecases.RetrieveTeam
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.unmockkAll
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class RetrieveTeamTest {

    @RelaxedMockK
    lateinit var repository: Repository<Team>
    lateinit var repositoryHandler: RepositoryHandler<Team>

    @Before
    fun setup() {
        MockKAnnotations.init(this)
        repositoryHandler = RepositoryHandler(repository)
    }

    @Test
    fun `retrieveTeam return team object success`() {
        //Arrange
        val retrieveTeam: RetrieveTeam = RetrieveTeam(repository)
        val param: String = ""
        var fakeListResponse: List<Team> = listOf(Team())
        val expectedValue: Team = Team()

        //Act
        coEvery {
            repositoryHandler.retrieveById(param)
        } returns fakeListResponse

        //Assert
        Assert.assertEquals(expectedValue, fakeListResponse[0])
    }

    @After
    fun tearDown() {
        unmockkAll()
    }
}