package com.companytest.thesports

import com.companytest.thesports.data.EventRepositoryHandler
import com.companytest.thesports.domain.Event
import com.companytest.thesports.domain.ResultWrapper
import com.companytest.thesports.usecases.RetrieveAllEventsByTeamId
import io.mockk.every
import io.mockk.mockk
import io.mockk.unmockkAll
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class RetrieveAllEventsByTeamIdTest {

    private val repositoryHandlerFullData: EventRepositoryHandler = mockk()
    private val flowFullData: Flow<ResultWrapper<List<Event>>> = flowOf(ResultWrapper.Success(listOf(Event("1"), Event("2"), Event("3"))))
    @Before
    fun setup() {
        every {
            repositoryHandlerFullData.retrieveById("")
        } returns flowFullData
    }

    @Test
    fun `retrieveAllEventsByTeamId return all event success`() {
        //Arrange
        val retrieveEvensUseCase: RetrieveAllEventsByTeamId = RetrieveAllEventsByTeamId(repositoryHandlerFullData)
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
        unmockkAll()
    }
}