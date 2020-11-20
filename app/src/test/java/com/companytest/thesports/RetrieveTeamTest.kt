package com.companytest.thesports

import com.companytest.thesports.data.TeamRepositoryHandler
import com.companytest.thesports.domain.ResultWrapper
import com.companytest.thesports.domain.Team
import com.companytest.thesports.domain.repository.LocalRepository
import com.companytest.thesports.domain.repository.RemoteRepository
import com.companytest.thesports.fake.FakeTeamFullDataLocalRepository
import com.companytest.thesports.fake.FakeTeamFullDataRemoteRepository
import com.companytest.thesports.usecases.RetrieveTeam
import io.mockk.unmockkAll
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class RetrieveTeamTest {

    @Before
    fun setup() {
    }
    @Test
    fun `retrieveTeam return team object success`() {
        //Arrange
        val localRepository: LocalRepository<Team> = FakeTeamFullDataLocalRepository()
        val remoteRepository: RemoteRepository<Team> = FakeTeamFullDataRemoteRepository()
        val repositoryHandler: TeamRepositoryHandler = TeamRepositoryHandler(localRepository, remoteRepository)

        val retrieveTeamUseCase: RetrieveTeam = RetrieveTeam(repositoryHandler)
        val expectedValue = Team("3", "Team tree")
        val param: String = ""

        //Act
        val response = retrieveTeamUseCase.retrieveTeam(param)

        //Assert
        runBlocking {
            response.collect { resultWrapperResponse: ResultWrapper<Team> ->
                when (resultWrapperResponse) {
                    is ResultWrapper.Loading -> {
                        Assert.assertEquals(ResultWrapper.Loading, resultWrapperResponse)
                    }
                    is ResultWrapper.Success -> {
                        Assert.assertEquals(expectedValue, resultWrapperResponse.data)
                    }
                    is ResultWrapper.Error -> {
                        Assert.assertEquals(ResultWrapper.Error(""), resultWrapperResponse)
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