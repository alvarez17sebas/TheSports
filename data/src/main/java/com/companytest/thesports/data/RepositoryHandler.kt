package com.companytest.thesports.data

import com.companytest.thesports.domain.repository.LocalRepository
import com.companytest.thesports.domain.repository.RemoteRepository

abstract class RepositoryHandler<T> constructor(
    val localRepository: LocalRepository<T>,
    val remoteRepository: RemoteRepository<T>
) {
    suspend fun retrieveAll(parameter: String): List<T> {
        var dataList: List<T> = listOf()
        dataList = localRepository.getAll(parameter)

        if(dataList.isEmpty()){
            dataList = remoteRepository.retrieveAll(parameter)
            dataList.forEach {
                localRepository.save(it)
            }
        }
        return dataList
    }

    suspend fun retrieveById(id: String): List<T> {
        var dataList: List<T> = localRepository.getById(id)
        if(dataList.isEmpty()){
            dataList = remoteRepository.retrieveById(id)
            dataList.forEach {
                localSave(it, id)
            }
        }
        return dataList
    }

    abstract suspend fun localSave(data: T, id: String)
}