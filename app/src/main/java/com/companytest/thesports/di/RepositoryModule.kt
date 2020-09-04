package com.companytest.thesports.di

import com.companytest.thesports.model.Event
import com.companytest.thesports.model.Team
import com.companytest.thesports.repository.EventRepository
import com.companytest.thesports.repository.RemoteRepository
import com.companytest.thesports.repository.TeamRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent

@InstallIn(ActivityRetainedComponent::class)
@Module
object TeamRepositoryModule{

    @Provides
    fun provideTeamRepository(): RemoteRepository<Team>{
        return TeamRepository()
    }

}

@InstallIn(ActivityRetainedComponent::class)
@Module
object EventRepositoryModule{

    @Provides
    fun provideEventRepository(): RemoteRepository<Event>{
        return EventRepository()
    }

}