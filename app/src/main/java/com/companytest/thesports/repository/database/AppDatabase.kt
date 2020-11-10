package com.companytest.thesports.repository.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.companytest.thesports.repository.database.dao.EventDao
import com.companytest.thesports.repository.database.dao.TeamDao
import com.companytest.thesports.repository.database.entity.EventEntity
import com.companytest.thesports.repository.database.entity.TeamEntity

@Database(entities = [TeamEntity::class, EventEntity::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun teamDao(): TeamDao
    abstract fun eventDao(): EventDao
}