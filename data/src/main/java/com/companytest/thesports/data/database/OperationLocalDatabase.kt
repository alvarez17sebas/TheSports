package com.companytest.thesports.data.database

import kotlinx.coroutines.flow.Flow

interface OperationLocalDatabase<T>{

    fun save(data: T)

    fun saveAll(dataList: List<T>)

    fun update(data: T)

    fun getAll(): Flow<List<T>>

    fun getById(id: String): Flow<List<T>>

    fun delete(data: T)
}