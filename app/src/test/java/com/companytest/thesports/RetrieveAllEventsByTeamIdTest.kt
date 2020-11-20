package com.companytest.thesports

import com.companytest.thesports.data.EventRepositoryHandler
import com.companytest.thesports.data.RepositoryHandler
import com.companytest.thesports.data.TeamRepositoryHandler
import com.companytest.thesports.domain.Event
import com.companytest.thesports.domain.ResultWrapper
import com.companytest.thesports.domain.Team
import com.companytest.thesports.domain.repository.LocalRepository
import com.companytest.thesports.domain.repository.RemoteRepository
import com.companytest.thesports.fake.FakeEventFullDataLocalRepository
import com.companytest.thesports.fake.FakeEventFullDataRemoteRepository
import com.companytest.thesports.usecases.RetrieveAllEventsByTeamId
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.unmockkAll
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class RetrieveAllEventsByTeamIdTest {

    @Before
    fun setup() {
        MockKAnnotations.init(this)
    }

    @Test
    fun `retrieveAllEventsByTeamId return all event success`() {
        //Arrange
        val localRepository: LocalRepository<Event> = FakeEventFullDataLocalRepository()
        val remoteRepository: RemoteRepository<Event> = FakeEventFullDataRemoteRepository()
        val repositoryHandler: EventRepositoryHandler = EventRepositoryHandler(localRepository, remoteRepository)

        val retrieveEvensUseCase: RetrieveAllEventsByTeamId = RetrieveAllEventsByTeamId(repositoryHandler)
        val parameter = ""
        val expectedValue: List<Event> = listOf(Event("1"), Event("2"), Event("3"))

        //Act
        val response = retrieveEvensUseCase.retrieveEventsByTeamId(parameter)

        //Assert
        runBlocking {
            response.collect {
                    value: ResultWrapper<List<Event>> ->
                when(value) {
                    is ResultWrapper.Loading -> {Assert.assertEquals(ResultWrapper.Loading, value)}
                    is ResultWrapper.Success -> {Assert.assertEquals(expectedValue, value.data)}
                    is ResultWrapper.Error -> {Assert.assertEquals(ResultWrapper.Error(""), value)}
                }
            }
        }
    }

    @After
    fun tearDown() {
    }
}