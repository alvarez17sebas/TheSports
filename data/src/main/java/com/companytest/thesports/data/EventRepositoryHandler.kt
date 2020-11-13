package com.companytest.thesports.data

import com.companytest.thesports.domain.Event
import com.companytest.thesports.domain.repository.LocalRepository
import com.companytest.thesports.domain.repository.RemoteRepository
import javax.inject.Inject

class EventRepositoryHandler @Inject constructor(
    localRepository: LocalRepository<Event>,
    remoteRepository: RemoteRepository<Event>
) : RepositoryHandler<Event>(localRepository, remoteRepository) {

    override suspend fun localSave(dataList: List<Event>, id: String) {
        dataList.forEach {event: Event ->
            localRepository.save(event.apply { idTeam = id })
        }
    }

}