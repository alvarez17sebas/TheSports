package com.companytest.thesports.repository.database.dao

import androidx.room.*
import com.companytest.thesports.repository.database.entity.EventEntity

@Dao
interface EventDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun save(event: EventEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveAll(events: List<EventEntity>)

    @Update
    suspend fun update(event: EventEntity)

    @Query("SELECT * FROM event")
    suspend fun getAll(): List<EventEntity>

    @Query("SELECT * FROM event WHERE id_team = :id")
    suspend fun getById(id: String): List<EventEntity>

    @Delete
    suspend fun delete(data: EventEntity)
}