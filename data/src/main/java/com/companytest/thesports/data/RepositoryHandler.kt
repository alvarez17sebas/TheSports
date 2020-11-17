package com.companytest.thesports.data

import com.companytest.thesports.domain.ResultWrapper
import com.companytest.thesports.domain.repository.LocalRepository
import com.companytest.thesports.domain.repository.RemoteRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*

abstract class RepositoryHandler<T> constructor(
    val localRepository: LocalRepository<T>,
    val remoteRepository: RemoteRepository<T>
) {

    private fun getFlowRemoteRepository(leagueParameter: String): Flow<List<T>> {
        return flow {
            val response: List<T> = remoteRepository.retrieveAll(leagueParameter)
            localRepository.saveAll(response)
            emit(response)
        }
    }

    fun retrieveAll(leagueParameter: String): Flow<ResultWrapper<List<T>>> {

        return localRepository.getAll(leagueParameter).flatMapLatest { localData: List<T> ->
            if (localData.isNotEmpty()) {
                flowOf(localData)
            } else {
                getFlowRemoteRepository(leagueParameter)
            }
        }.map {
            val response: ResultWrapper<List<T>> = ResultWrapper.Success(it)
            response
        }.onStart {
            emit(ResultWrapper.Loading)
        }.catch {
            emit(ResultWrapper.Error("Network error"))
        }.flowOn(Dispatchers.IO)

        /*return getFlowRemoteRepository(leagueParameter).map {
    val response: ResultWrapper<List<T>> = ResultWrapper.Success(it)
    response
}.onStart {
    emit(ResultWrapper.Loading)
}.catch {
    emit(ResultWrapper.Error("Not Internet"))
}.flowOn(Dispatchers.IO)*/

        /*val a:Flow<ResultWrapper<List<T>>> = localRepository.getAll(leagueParameter).flatMapLatest { localData: List<T> ->
           if(localData.isNotEmpty())
               flowOf(ResultWrapper.Success(localData))
           else{
               remoteRepository.retrieveAll(leagueParameter).map {
                   localRepository.saveAll((it as ResultWrapper.Success).data)
                   it
               }
           }
       }
       return a*/

        /*return remoteRepository.retrieveAll(leagueParameter).map {
            val response: ResultWrapper<List<T>> = ResultWrapper.Success(it)
            response
        }.flowOn(Dispatchers.IO)*/

        /*return merge(
            remoteRepository.retrieveAll(leagueParameter),
            localRepository.getAll(leagueParameter)
        ).map {
            val response: ResultWrapper<List<T>> = ResultWrapper.Success(it)
            response
        }
            .onStart {
                emit(ResultWrapper.Loading)
            }
            .catch {
                emit(ResultWrapper.Error("Not internet."))
            }.flowOn(Dispatchers.IO)*/
    }

/*fun retrieveAll(parameter: String): Flow<List<T>> {

    return  localRepository.getAll(parameter).flatMapLatest { localData: List<T> ->
        if(localData.isNotEmpty())
            flowOf(localData)
        else{
            remoteRepository.retrieveAll(parameter).map {
                localRepository.saveAll(it)
                it
            }
        }
    }
}*/

    fun retrieveById(id: String): Flow<ResultWrapper<List<T>>> {

        return localRepository.getById(id).flatMapConcat { localData: List<T> ->
            if (localData.isNotEmpty())
                flowOf(localData)
            else {
                remoteRepository.retrieveById(id).onEach {
                    localSave(it, id)
                }
            }
        }.map {
            val response: ResultWrapper<List<T>> = ResultWrapper.Success(it)
            response
        }
    }

    abstract suspend fun localSave(dataList: List<T>, id: String)

}