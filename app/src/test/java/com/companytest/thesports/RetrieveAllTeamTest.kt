package com.companytest.thesports

import com.companytest.thesports.data.RepositoryHandler
import com.companytest.thesports.data.TeamRepositoryHandler
import com.companytest.thesports.domain.ResultWrapper
import com.companytest.thesports.domain.Team
import com.companytest.thesports.domain.repository.LocalRepository
import com.companytest.thesports.domain.repository.RemoteRepository
import com.companytest.thesports.usecases.RetrieveAllTeams
import io.mockk.*
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
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

    private val teamsMock: List<Team> = listOf(Team("1", "Team One"), Team("2", "Team Two"))

    private val successMockState = ResultWrapper.Success(teamsMock)

    private val successMockFlow = flow {
        emit(successMockState)
    }

    //private val flowSuccess: Flow<ResultWrapper<List<Team>>> = flow {
      //  emit(ResultWrapper.Success(teamsMock))
    //}

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
    fun retrieveAllTeamsSuccess() {
        //Arrange
        val retrieveTeamsUseCase: RetrieveAllTeams = RetrieveAllTeams(teamRepositoryHandler)
        val expectedValue: ResultWrapper<List<Team>> = ResultWrapper.Success(teamsMock)
        val parameter = ""

        //Act
        every {
            teamRepositoryHandler.retrieveAll(parameter)
        }.answers {
            successMockFlow
        }

        val response: Flow<ResultWrapper<List<Team>>> = retrieveTeamsUseCase.retrieveTeams(parameter)

        //Assert
        runBlocking {
            response.collect {
                when(it){
                    is ResultWrapper.Loading -> {
                        assert(it is ResultWrapper.Loading)
                    }
                    is ResultWrapper.Success -> {
                        assert(it  is  ResultWrapper.Success)
                    }
                }
            }
        }
    }


    fun retrieveAllTeamsSuccess_2() {
        //Arrange
        val retrieveTeamsUseCase: RetrieveAllTeams = RetrieveAllTeams(teamRepositoryHandler)
        val expectedValue = listOf(Team("1", "Team One"), Team("2", "Team Two"))
        val parameter = ""

        //Act
        every {
            teamRepositoryHandler.retrieveAll(parameter)
        } returns successMockFlow

        var response: Flow<List<Team>> = retrieveTeamsUseCase.retrieveTeams(parameter).map {
            var dataList: List<Team> = (it as ResultWrapper.Success).data
            dataList

        }

        //Assert
        runBlocking {
            response.collect {
                Assert.assertEquals(expectedValue, it)
            }
        }
    }

    fun `retrieveAllTeams return all teams success`() {

        var repositoryHandler: TeamRepositoryHandler = TeamRepositoryHandler(mockk(relaxed = true), mockk(relaxed = true))
        var retrieveAllTeamsUseCase: RetrieveAllTeams = RetrieveAllTeams(repositoryHandler)
        var fakeFlow: Flow<ResultWrapper<List<Team>>> = flow {
            emit(ResultWrapper.Success(listOf(Team("1"), Team("2"))))
        }

        every {
            repositoryHandler.retrieveAll("")
        } returns  fakeFlow

        var response: Flow<ResultWrapper<List<Team>>> = retrieveAllTeamsUseCase.retrieveTeams("")

        runBlocking {
            response.collect {
                assert(it is ResultWrapper.Success)
            }
        }
    }

    //@Test
    fun otherTest() {
        //Arrange
        var localRepository: LocalRepository<Team> = mockk(relaxed = true)
        var remoteRepository: RemoteRepository<Team> = mockk(relaxed = true)
        var repositoryHandler: RepositoryHandler<Team> =
            TeamRepositoryHandler(localRepository, remoteRepository)

        var retrieveAllTeamUseCase: RetrieveAllTeams =
            RetrieveAllTeams(repositoryHandler as TeamRepositoryHandler)

        val parameter = ""
        var team: Team = Team("1", "Team One")
        var team2: Team = Team("2", "Team Two")

        val expectedValue: List<Team> = listOf(team, team2)
        var fakeResultWrapper: ResultWrapper<List<Team>> = ResultWrapper.Success(listOf(team, team2))
        var fakeFlowResponse: Flow<ResultWrapper<List<Team>>> = flowOf(fakeResultWrapper)

        //Act
        every {
            repositoryHandler.retrieveAll(parameter)
        } returns fakeFlowResponse

        val responseUseCase: Flow<List<Team>> = retrieveAllTeamUseCase.retrieveTeams(parameter).map {
            var list: List<Team> = (it as ResultWrapper.Success).data
            list
        }

        //Assert
        runBlocking {
            responseUseCase.collect {
                Assert.assertEquals(expectedValue, it)
            }
        }
    }

    /*@Test
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
    }*/

    @After
    fun tearDown() {
        unmockkAll()
    }
}