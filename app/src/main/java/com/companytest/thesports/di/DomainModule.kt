package com.companytest.thesports.di

import com.companytest.thesports.domain.TeamDomain
import com.companytest.thesports.repository.TeamRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent

@InstallIn(ActivityRetainedComponent::class)
@Module
object DomainModule {

    @Provides
    fun provideTeamDomain(repository: TeamRepository): TeamDomain {
        return TeamDomain(repository)
    }
}