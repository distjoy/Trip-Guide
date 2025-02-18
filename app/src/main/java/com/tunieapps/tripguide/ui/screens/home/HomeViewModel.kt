package com.tunieapps.tripguide.ui.screens.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tunieapps.tripguide.data.PlacesRepository
import com.tunieapps.tripguide.model.Place
import com.tunieapps.tripguide.model.PlacesFilter
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach

class HomeViewModel(val placeRepository: PlacesRepository) : ViewModel(){

    private val _places = MutableStateFlow(listOf<Place>())

    val places = _places as StateFlow<List<Place>>

    fun getPlaces(placesFilter: PlacesFilter = PlacesFilter.All) {
        placeRepository.getPlaces().onEach{

        }.launchIn(viewModelScope)
    }



}