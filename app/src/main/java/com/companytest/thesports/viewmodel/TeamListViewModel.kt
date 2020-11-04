package com.companytest.thesports.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.companytest.thesports.domain.Team

import com.companytest.thesports.usecases.RetrieveAllTeams
import kotlinx.coroutines.launch

class TeamListViewModel @ViewModelInject constructor(private val retrieveAllTeams: RetrieveAllTeams) : ViewModel() {


    private val _teamsLiveData: MutableLiveData<List<Team>> = MutableLiveData()
    val itemsLiveData: LiveData<List<Team>> = _teamsLiveData

    private val _loading: MutableLiveData<Boolean> = MutableLiveData()
    val loading: LiveData<Boolean> = _loading

    fun retrieveAllTeams(leagueParameter: String){
        viewModelScope.launch {
            var response: List<Team>? = null
            _loading.value = true
            response = retrieveAllTeams.retrieveTeams(leagueParameter)
            _loading.value = false
            _teamsLiveData.value = response
        }
    }
}