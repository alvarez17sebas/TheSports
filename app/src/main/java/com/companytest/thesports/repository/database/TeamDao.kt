package com.companytest.thesports.repository.database

import androidx.room.*
import com.companytest.thesports.repository.database.entity.TeamEntity

@Dao
interface TeamDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun save(team: TeamEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveAll(teams: List<TeamEntity>)

    @Update
    suspend fun update(team: TeamEntity)

    @Query("SELECT * FROM team")
    suspend fun getAll(): List<TeamEntity>

    @Query("SELECT * FROM team WHERE id_team = :id")
    suspend fun getById(id: String): List<TeamEntity>

    @Delete
    suspend fun delete(data: TeamEntity)
}