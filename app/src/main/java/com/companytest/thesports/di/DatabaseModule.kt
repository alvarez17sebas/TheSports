package com.companytest.thesports.di

import android.content.Context
import androidx.room.Room
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.companytest.thesports.data.database.OperationLocalDatabase
import com.companytest.thesports.domain.Team
import com.companytest.thesports.repository.database.AppDatabase
import com.companytest.thesports.repository.database.OperationTeamLocalDatabaseImpl
import com.companytest.thesports.repository.database.TeamDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@InstallIn(ApplicationComponent::class)
@Module
object DatabaseModule {
    @Provides
    fun provideDatabaseInstance(@ApplicationContext context: Context): AppDatabase {
        synchronized(this){
            return Room.databaseBuilder(
                context.applicationContext,
                AppDatabase::class.java,
                "sportdb")
                .addMigrations(MIGRATION_1_2)
                .build()
        }
    }

    private val MIGRATION_1_2: Migration = object : Migration(1, 2) {
        override fun migrate(database: SupportSQLiteDatabase) {
            val query: String = "ALTER TABLE character ADD COLUMN score FLOAT DEFAULT 0"
            database.execSQL(query)
        }
    }

    @Provides
    fun provideTeamDao(database: AppDatabase): TeamDao {
         return database.teamDao()
    }

    @Provides
    fun provideTeamLocalRepository(teamDao: TeamDao): OperationLocalDatabase<Team> {
        return OperationTeamLocalDatabaseImpl(teamDao)
    }
}