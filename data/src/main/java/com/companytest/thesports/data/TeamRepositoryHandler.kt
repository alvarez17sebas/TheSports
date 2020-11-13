package com.companytest.thesports.data

import com.companytest.thesports.data.RepositoryHandler
import com.companytest.thesports.domain.Team
import com.companytest.thesports.domain.repository.LocalRepository
import com.companytest.thesports.domain.repository.RemoteRepository
import javax.inject.Inject

class TeamRepositoryHandler @Inject constructor(
    localRepository: LocalRepository<Team>,
    remoteRepository: RemoteRepository<Team>
) : RepositoryHandler<Team>(localRepository, remoteRepository) {

    override suspend fun localSave(dataList: List<Team>, id: String) {
        dataList.forEach {team: Team ->
            localRepository.save(team)
        }
    }
}