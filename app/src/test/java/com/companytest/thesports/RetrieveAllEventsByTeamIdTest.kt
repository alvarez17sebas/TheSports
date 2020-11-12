package com.companytest.thesports

import com.companytest.thesports.domain.repository.TeamRepository
import com.companytest.thesports.data.TeamRepositoryHandler
import com.companytest.thesports.domain.Event
import com.companytest.thesports.usecases.RetrieveAllEventsByTeamId
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

class RetrieveAllEventsByTeamIdTest {

    @RelaxedMockK
    lateinit var teamRepository: TeamRepository<Event>
    lateinit var teamRepositoryHandler: TeamRepositoryHandler<Event>

    @Before
    fun setup() {
        MockKAnnotations.init(this)
        teamRepositoryHandler =
            TeamRepositoryHandler(
                teamRepository
            )
    }

    @Test
    fun `retrieveAllEventsByTeamId return all event success`() {
        //Arrange
        val retrieveEvents: RetrieveAllEventsByTeamId = RetrieveAllEventsByTeamId(teamRepositoryHandler)
        val parameter: String = ""
        val fakeResponse: Flow<List<Event>> = flowOf(listOf(Event(), Event(), Event()))
        val responseExpected: List<Event> = listOf(Event(), Event(), Event())
        var response: List<Event>? = null

        //Act
        coEvery {
            teamRepositoryHandler.retrieveById(parameter)
        } returns fakeResponse

        runBlocking {
            response = retrieveEvents.retrieveEventsByTeamId(parameter).single()
        }

        //Assert
        Assert.assertEquals(responseExpected, response)
    }

    @After
    fun tearDown() {
        unmockkAll()
    }
}