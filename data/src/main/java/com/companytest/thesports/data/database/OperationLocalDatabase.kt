package com.companytest.thesports.data.database

import kotlinx.coroutines.flow.Flow

interface OperationLocalDatabase<T>{

    suspend fun save(data: T)

    suspend fun saveAll(dataList: List<T>)

    suspend fun update(data: T)

    suspend fun getAll(): List<T>

    suspend fun getById(id: String): List<T>

    suspend fun delete(data: T)
}