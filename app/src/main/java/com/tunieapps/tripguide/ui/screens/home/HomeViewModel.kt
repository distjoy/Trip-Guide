package com.tunieapps.tripguide.ui.screens.home

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tunieapps.tripguide.data.PlacesRepository
import com.tunieapps.tripguide.model.Place
import com.tunieapps.tripguide.model.PlacesFilter
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(val placeRepository: PlacesRepository) : ViewModel(){

    private val _places = MutableStateFlow(listOf<Place>())

    val places = _places as StateFlow<List<Place>>

    fun getPlaces(placesFilter: PlacesFilter = PlacesFilter.All) {
        placeRepository.getPlaces()
            .map {
                val places : MutableList<Place> = mutableListOf()
                it.forEach { place ->
                    places.add(
                      Place(place.id,place.displayName.text, "", emptyList(),
                          place.photos[0].name,place.rating,place.reviews,place.shortAddress)
                    )
                }
                places
            }.onEach{
            Log.d("HomeViewModel", "getPlaces: ${it}")

        }.catch {
            it.printStackTrace()
        } .launchIn(viewModelScope)
    }



}