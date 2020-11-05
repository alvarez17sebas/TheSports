package com.companytest.thesports.di

import com.companytest.thesports.data.Repository
import com.companytest.thesports.domain.Event
import com.companytest.thesports.domain.Team
import com.companytest.thesports.repository.EventRepository
import com.companytest.thesports.repository.TeamRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent

@InstallIn(ActivityRetainedComponent::class)
@Module
object TeamRepositoryModule {

    @Provides
    fun provideTeamRepository(): Repository<Team> {
        return TeamRepository()
    }

    @Provides
    fun provideEventRepository(): Repository<Event> {
        return EventRepository()
    }

}