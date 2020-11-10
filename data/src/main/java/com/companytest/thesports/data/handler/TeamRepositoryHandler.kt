package com.companytest.thesports.data.handler

import com.companytest.thesports.domain.Team
import com.companytest.thesports.domain.repository.LocalRepository
import com.companytest.thesports.domain.repository.RemoteRepository
import javax.inject.Inject

class TeamRepositoryHandler @Inject constructor(
    localRepository: LocalRepository<Team>,
    remoteRepository: RemoteRepository<Team>
) : RepositoryHandler<Team>(localRepository, remoteRepository) {
    override suspend fun localSave(data: Team, id: String) {
        localRepository.save(data)
    }
}