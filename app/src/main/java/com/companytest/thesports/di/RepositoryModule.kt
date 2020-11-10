package com.companytest.thesports.di

import com.companytest.thesports.data.EventRepositoryImpl
import com.companytest.thesports.data.EventLocalDatabase
import com.companytest.thesports.data.TeamRepositoryImpl
import com.companytest.thesports.data.TeamLocalDatabase
import com.companytest.thesports.data.database.OperationLocalDatabase
import com.companytest.thesports.domain.Event
import com.companytest.thesports.domain.Team
import com.companytest.thesports.domain.repository.*
import com.companytest.thesports.repository.network.SportService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent


@InstallIn(ActivityRetainedComponent::class)
@Module
object TeamRepositoryModule {

    @Provides
    fun provideTeamRepository(sportService: SportService): RemoteRepository<Team> {
        return TeamRepositoryImpl(sportService)
    }

    @Provides
    fun provideEventRepository(sportService: SportService): RemoteRepository<Event> {
        return EventRepositoryImpl(sportService)
    }

    @Provides
    fun provideTeamLocalRepository(operationLocalDatabase: OperationLocalDatabase<Team>): LocalRepository<Team> {
        return TeamLocalDatabase(operationLocalDatabase)
    }

    @Provides
    fun provideEventLocalRepository(operationLocalDatabase: OperationLocalDatabase<Event>): LocalRepository<Event> {
        return EventLocalDatabase(operationLocalDatabase)
    }
}