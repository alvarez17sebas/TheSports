package com.companytest.thesports.data.handler

import com.companytest.thesports.domain.Event
import com.companytest.thesports.domain.repository.LocalRepository
import com.companytest.thesports.domain.repository.RemoteRepository
import javax.inject.Inject

class EventRepositoryHandler @Inject constructor(
    localRepository: LocalRepository<Event>,
    remoteRepository: RemoteRepository<Event>
) : RepositoryHandler<Event>(localRepository, remoteRepository) {

    override suspend fun localSave(data: Event, id: String) {
        data.idTeam = id
        localRepository.save(data)
    }

}