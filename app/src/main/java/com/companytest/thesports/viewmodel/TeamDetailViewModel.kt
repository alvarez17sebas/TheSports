package com.companytest.thesports.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.companytest.thesports.domain.Event
import com.companytest.thesports.domain.ResultWrapper
import com.companytest.thesports.domain.Team
import com.companytest.thesports.usecases.RetrieveAllEventsByTeamId
import com.companytest.thesports.usecases.RetrieveTeam
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class TeamDetailViewModel @ViewModelInject constructor(private val retrieveTeam: RetrieveTeam, private val retrieveAllEventsByTeamId: RetrieveAllEventsByTeamId) : ViewModel() {

    private var _teamLiveData: MutableLiveData<ResultWrapper<Team>> = MutableLiveData()
    var teamLiveData: LiveData<ResultWrapper<Team>> = _teamLiveData

    private var _eventsLiveData: MutableLiveData<ResultWrapper<List<Event>>> = MutableLiveData()
    var eventsLiveData: LiveData<ResultWrapper<List<Event>>> = _eventsLiveData

    private val _loading: MutableLiveData<Boolean> = MutableLiveData()
    val loading: LiveData<Boolean> = _loading

    fun retrieveTeam(idTeam: String){
        viewModelScope.launch {
            retrieveTeam.retrieveTeam(idTeam).collect {
                _teamLiveData.value = it
            }
        }
    }

    fun retrieveNextEventsByTeamId(teamId: String){
        viewModelScope.launch {
            retrieveAllEventsByTeamId.retrieveEventsByTeamId(teamId).collect {
                _eventsLiveData.value = it
            }
        }
    }

}