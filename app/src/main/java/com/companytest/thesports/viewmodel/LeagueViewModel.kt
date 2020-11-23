package com.companytest.thesports.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.companytest.thesports.domain.League
import com.companytest.thesports.domain.ResultWrapper
import com.companytest.thesports.usecases.RetrieveAllLeague
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class LeagueViewModel @ViewModelInject constructor(val retrieveAllLeague: RetrieveAllLeague) : ViewModel() {

    private var _lvLeagues: MutableLiveData<ResultWrapper<List<League>>> = MutableLiveData()
    var lvLeague: LiveData<ResultWrapper<List<League>>> = _lvLeagues

    fun retrieveAllLeagues() {
        viewModelScope.launch {
            retrieveAllLeague.retrieveAllLeagues().collect {
                _lvLeagues.value = it
            }
        }
    }
}