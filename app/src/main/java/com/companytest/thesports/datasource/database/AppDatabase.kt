package com.companytest.thesports.datasource.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.companytest.thesports.datasource.database.dao.EventDao
import com.companytest.thesports.datasource.database.dao.LeagueDao
import com.companytest.thesports.datasource.database.dao.TeamDao
import com.companytest.thesports.datasource.database.entity.EventEntity
import com.companytest.thesports.datasource.database.entity.LeagueEntity
import com.companytest.thesports.datasource.database.entity.TeamEntity

@Database(entities = [TeamEntity::class, EventEntity::class, LeagueEntity::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun teamDao(): TeamDao
    abstract fun eventDao(): EventDao
    abstract fun leagueDao(): LeagueDao
}