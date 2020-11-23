package com.companytest.thesports.di

import com.companytest.thesports.domain.Event
import com.companytest.thesports.domain.Team
import com.companytest.thesports.domain.repository.LocalRepository
import com.companytest.thesports.domain.repository.RemoteRepository
import com.companytest.thesports.datasource.database.dao.EventDao
import com.companytest.thesports.datasource.database.dao.LeagueDao
import com.companytest.thesports.datasource.database.dao.TeamDao
import com.companytest.thesports.datasource.network.LeagueService
import com.companytest.thesports.datasource.network.SportService
import com.companytest.thesports.domain.repository.LeagueRemoteRepository
import com.companytest.thesports.domain.repository.LocalLeagueRepository
import com.companytest.thesports.repositoryimpl.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent


@InstallIn(ActivityRetainedComponent::class)
@Module
object TeamRepositoryModule {

    @Provides
    fun provideTeamRepository(sportService: SportService): RemoteRepository<Team> {
        return TeamRepositoryImpl(
            sportService
        )
    }

    @Provides
    fun provideEventRepository(sportService: SportService): RemoteRepository<Event> {
        return EventRepositoryImpl(
            sportService
        )
    }

    @Provides
    fun provideTeamLocalRepository(teamDao: TeamDao): LocalRepository<Team> {
        return TeamLocalDatabaseImpl(
            teamDao
        )
    }

    @Provides
    fun provideEventLocalRepository(eventDao: EventDao): LocalRepository<Event> {
        return EventLocalDatabaseImpl(
            eventDao
        )
    }

    @Provides
    fun provideLeagueLocalRepository(leagueDao: LeagueDao): LocalLeagueRepository {
        return LocalRoomDatabaseLeague(leagueDao)
    }

    @Provides
    fun provideLeagueRemoteRepository(leagueService: LeagueService): LeagueRemoteRepository {
        return RemoteRetrofitLeague(leagueService)
    }
}