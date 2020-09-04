package com.companytest.thesports.di

import com.companytest.thesports.model.Team
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