package com.companytest.thesports.repository.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.companytest.thesports.repository.database.entity.TeamEntity

@Database(entities = [TeamEntity::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun teamDao(): TeamDao
}