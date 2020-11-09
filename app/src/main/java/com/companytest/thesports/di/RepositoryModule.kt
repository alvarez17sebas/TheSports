package com.companytest.thesports.di

import com.companytest.thesports.data.EventRepository
import com.companytest.thesports.data.TeamRepository
import com.companytest.thesports.data.TeamRoomLocalDatabase
import com.companytest.thesports.data.database.OperationLocalDatabase
import com.companytest.thesports.domain.Event
import com.companytest.thesports.domain.Team
import com.companytest.thesports.domain.repository.Repository
import com.companytest.thesports.domain.repository.TeamLocalRepository
import com.companytest.thesports.repository.network.SportService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent


@InstallIn(ActivityRetainedComponent::class)
@Module
object TeamRepositoryModule {

    @Provides
    fun provideTeamRepository(sportService: SportService): Repository<Team> {
        return TeamRepository(sportService)
    }

    @Provides
    fun provideEventRepository(sportService: SportService): Repository<Event> {
        return EventRepository(sportService)
    }

    @Provides
    fun provideTeamLocalRepository(operationLocalDatabase: OperationLocalDatabase<Team>): TeamLocalRepository {
        return TeamRoomLocalDatabase(operationLocalDatabase)
    }
}