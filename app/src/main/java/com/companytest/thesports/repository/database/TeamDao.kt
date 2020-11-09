package com.companytest.thesports.repository.database

import androidx.room.*
import com.companytest.thesports.data.database.OperationLocalDatabase
import kotlinx.coroutines.flow.Flow

@Dao
interface TeamDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
     fun save(team: TeamEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
     fun saveAll(teams: List<TeamEntity>)

    @Update
     fun update(team: TeamEntity)

    @Query("SELECT * FROM team")
    fun getAll(): Flow<List<TeamEntity>>

    @Query("SELECT * FROM team WHERE id_team = :id")
    fun getById(id: String): Flow<List<TeamEntity>>

    @Delete
    fun delete(data: TeamEntity)
}