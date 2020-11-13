package com.companytest.thesports.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.companytest.thesports.domain.Event
import com.companytest.thesports.domain.Team
import com.companytest.thesports.usecases.RetrieveAllEventsByTeamId
import com.companytest.thesports.usecases.RetrieveTeam
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class TeamDetailViewModel @ViewModelInject constructor(private val retrieveTeam: RetrieveTeam, private val retrieveAllEventsByTeamId: RetrieveAllEventsByTeamId) : ViewModel() {

    private var _teamLiveData: MutableLiveData<Team> = MutableLiveData()
    var teamLiveData: LiveData<Team> = _teamLiveData

    private var _eventsLiveData: MutableLiveData<List<Event>> = MutableLiveData()
    var eventsLiveData: LiveData<List<Event>> = _eventsLiveData

    private val _loading: MutableLiveData<Boolean> = MutableLiveData()
    val loading: LiveData<Boolean> = _loading

    fun retrieveTeam(idTeam: String){
        viewModelScope.launch {
            _loading.value = true
            retrieveTeam.retrieveTeam(idTeam).collect {
                _teamLiveData.value = it
                _loading.value = false
            }
        }
    }

    fun retrieveNextEventsByTeamId(teamId: String){
        viewModelScope.launch {
            _loading.value = true
            retrieveAllEventsByTeamId.retrieveEventsByTeamId(teamId).collect {
                _eventsLiveData.value = it
            }
            _loading.value = false
        }
    }

    /*fun retrieveTeam(idTeam: String): LiveData<Team>{
        return retrieveTeam.retrieveTeam(idTeam).onStart {
            _loading.value = true
        }.onCompletion {
            _loading.value = false
        }.asLiveData()
    }*/

    /*fun retrieveNextEventsByTeamId(teamId: String): LiveData<List<Event>>{

        return retrieveAllEventsByTeamId.retrieveEventsByTeamId(teamId).onStart {
            _loading.value = true
        }.onCompletion {
            _loading.value = false
        }.asLiveData()

    }*/
}