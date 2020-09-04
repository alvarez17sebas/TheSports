package com.companytest.thesports.repository

interface RemoteRepository<T> {
    suspend fun retrieveAll(): List<T>
    suspend fun retrieveById(id: String): List<T>
}