package com.companytest.thesports.data.team

import com.companytest.thesports.domain.ResultWrapper
import com.companytest.thesports.domain.repository.LocalRepository
import com.companytest.thesports.domain.repository.RemoteRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*

abstract class RepositoryHandler<T> constructor(
    val localRepository: LocalRepository<T>,
    val remoteRepository: RemoteRepository<T>
) {

    private fun toFlowRetrieveAll(leagueParameter: String): Flow<List<T>> {
        return flow {
            val response: List<T> = remoteRepository.retrieveAll(leagueParameter)
            localSave(response)
            emit(response)
        }
    }

    private fun toFlowRetrieveById(id: String): Flow<List<T>> {
        return flow {
            val response: List<T> = remoteRepository.retrieveById(id)
            localSave(response, id)
            emit(response)
        }
    }

    fun retrieveAll(leagueParameter: String): Flow<ResultWrapper<List<T>>> {
        return toFlowRetrieveAll(leagueParameter).map {
            val response: ResultWrapper<List<T>> = ResultWrapper.Success(it)
            response
        }

        /*return localRepository.getAll(leagueParameter).flatMapLatest { localData: List<T> ->
            if (localData.isNotEmpty()) {
                flowOf(localData)
            } else {
                toFlowRetrieveAll(leagueParameter)
            }
        }.map {
            val response: ResultWrapper<List<T>> = ResultWrapper.Success(it)
            response
        }.onStart {
            emit(ResultWrapper.Loading)
        }.catch {
            emit(ResultWrapper.Error("Network error"))
        }.flowOn(Dispatchers.IO)*/
    }

    fun retrieveById(id: String): Flow<ResultWrapper<List<T>>> {
        return localRepository.getById(id).flatMapConcat { localData: List<T> ->
            if (localData.isNotEmpty())
                flowOf(localData)
            else {
                toFlowRetrieveById(id)
            }
        }.map {
            var response: ResultWrapper<List<T>> = ResultWrapper.Success(it)
            response
        }.onStart {
            emit(ResultWrapper.Loading)
        }.catch {
            emit(ResultWrapper.Error("Network error"))
        }.flowOn(Dispatchers.IO)
    }

    abstract suspend fun localSave(dataList: List<T>, id: String = "")

}