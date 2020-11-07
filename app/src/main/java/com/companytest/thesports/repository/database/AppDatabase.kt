package com.companytest.thesports.repository.database

import androidx.room.RoomDatabase

abstract class AppDatabase : RoomDatabase() {
    abstract fun teamDao(): TeamDao
}