package com.companytest.thesports.data

import com.companytest.thesports.data.database.OperationLocalDatabase
import com.companytest.thesports.domain.repository.Repository
import kotlinx.coroutines.flow.Flow

class RoomLocalDatabase<T> constructor(var operationLocalDatabase: OperationLocalDatabase<T>): Repository<T> {
    override fun retrieveAll(leagueParameter: String): Flow<List<T>> {
        return operationLocalDatabase.getById(leagueParameter)
    }

    override fun retrieveById(id: String): Flow<List<T>> {
        return operationLocalDatabase.getById(id)
    }

    override fun save(data: T) {
         operationLocalDatabase.save(data)
    }
}