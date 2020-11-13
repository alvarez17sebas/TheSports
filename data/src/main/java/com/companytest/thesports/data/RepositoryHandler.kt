package com.companytest.thesports.data

import com.companytest.thesports.domain.repository.LocalRepository
import com.companytest.thesports.domain.repository.RemoteRepository
import kotlinx.coroutines.flow.*

abstract class RepositoryHandler<T> constructor(
    val localRepository: LocalRepository<T>,
    val remoteRepository: RemoteRepository<T>
) {

    fun retrieveAll(parameter: String): Flow<List<T>> {

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
    }

     fun retrieveById(id: String): Flow<List<T>> {

        return localRepository.getById(id).flatMapConcat {localData: List<T> ->
            if(localData.isNotEmpty())
                flowOf(localData)
            else{
                remoteRepository.retrieveById(id).map {
                    localSave(it, id)
                    it
                }
            }

        }
    }

    abstract suspend fun localSave(dataList: List<T>, id: String)
}