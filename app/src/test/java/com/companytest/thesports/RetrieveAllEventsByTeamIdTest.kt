package com.companytest.thesports

import com.companytest.thesports.domain.repository.Repository
import com.companytest.thesports.data.RepositoryHandler
import com.companytest.thesports.domain.Event
import com.companytest.thesports.usecases.RetrieveAllEventsByTeamId
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

class RetrieveAllEventsByTeamIdTest {

    @RelaxedMockK
    lateinit var repository: Repository<Event>
    lateinit var repositoryHandler: RepositoryHandler<Event>

    @Before
    fun setup() {
        MockKAnnotations.init(this)
        repositoryHandler = RepositoryHandler(repository)
    }

    @Test
    fun `retrieveAllEventsByTeamId return all event success`() {
        //Arrange
        val retrieveEvents: RetrieveAllEventsByTeamId = RetrieveAllEventsByTeamId(repositoryHandler)
        val parameter: String = ""
        val fakeResponse: Flow<List<Event>> = flowOf(listOf(Event(), Event(), Event()))
        val responseExpected: List<Event> = listOf(Event(), Event(), Event())
        var response: List<Event>? = null

        //Act
        coEvery {
            repositoryHandler.retrieveById(parameter)
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