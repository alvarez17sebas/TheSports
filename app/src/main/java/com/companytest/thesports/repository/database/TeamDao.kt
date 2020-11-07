package com.companytest.thesports.repository.database

import androidx.room.*
import com.companytest.thesports.data.database.OperationLocalDatabase
import kotlinx.coroutines.flow.Flow

@Dao
interface TeamDao : OperationLocalDatabase<TeamEntity> {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    override fun save(team: TeamEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    override fun saveAll(teams: List<TeamEntity>)

    @Update
    override fun update(team: TeamEntity)

    @Query("SELECT * FROM team")
    override fun getAll(): Flow<List<TeamEntity>>

    @Query("SELECT * FROM team WHERE id_team = :id")
    override fun getById(id: String): Flow<List<TeamEntity>>

    @Delete
    override fun delete(data: TeamEntity)
}