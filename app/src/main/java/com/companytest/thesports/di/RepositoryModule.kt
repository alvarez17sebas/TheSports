package com.companytest.thesports.di

import com.companytest.thesports.data.EventRepositoryImpl
import com.companytest.thesports.data.EventRoomLocalDatabase
import com.companytest.thesports.data.TeamRepositoryImpl
import com.companytest.thesports.data.TeamRoomLocalDatabase
import com.companytest.thesports.data.database.OperationLocalDatabase
import com.companytest.thesports.domain.Event
import com.companytest.thesports.domain.Team
import com.companytest.thesports.domain.repository.EventLocalRepository
import com.companytest.thesports.domain.repository.EventRepository
import com.companytest.thesports.domain.repository.TeamRepository
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
    fun provideTeamRepository(sportService: SportService): TeamRepository {
        return TeamRepositoryImpl(sportService)
    }

    @Provides
    fun provideEventRepository(sportService: SportService): EventRepository {
        return EventRepositoryImpl(sportService)
    }

    @Provides
    fun provideTeamLocalRepository(operationLocalDatabase: OperationLocalDatabase<Team>): TeamLocalRepository {
        return TeamRoomLocalDatabase(operationLocalDatabase)
    }

    @Provides
    fun provideEventLocalRepository(operationLocalDatabase: OperationLocalDatabase<Event>): EventLocalRepository {
        return EventRoomLocalDatabase(operationLocalDatabase)
    }
}