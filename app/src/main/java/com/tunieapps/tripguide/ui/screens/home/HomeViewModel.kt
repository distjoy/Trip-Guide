package com.tunieapps.tripguide.ui.screens.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tunieapps.tripguide.data.PlaceResponse
import com.tunieapps.tripguide.data.PlacesRepository
import com.tunieapps.tripguide.model.ALL
import com.tunieapps.tripguide.model.EDUCATION
import com.tunieapps.tripguide.model.ENTERTAINMENT
import com.tunieapps.tripguide.model.HOTELS
import com.tunieapps.tripguide.model.PARKS
import com.tunieapps.tripguide.model.Place
import com.tunieapps.tripguide.model.PlaceType
import com.tunieapps.tripguide.model.RESTAURANTS
import com.tunieapps.tripguide.model.SPORTS
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.shareIn
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(val placeRepository: PlacesRepository) : ViewModel(){

    private val _likedPlaces =   placeRepository.getPlaces(ALL.tags)
        .map {
            mapToUiData(it)
        }.catch {
            it.printStackTrace()
        }.shareIn(viewModelScope,started = SharingStarted.WhileSubscribed(),replay = 1)

    val likedPlaces = _likedPlaces

    private val _placesByFilter = MutableStateFlow(listOf<Place>())

    val placesByFilter = _placesByFilter as StateFlow<List<Place>>

    val _typeFilters = MutableStateFlow( listOf(
        ALL,
       RESTAURANTS,
        PARKS,
        ENTERTAINMENT,
        HOTELS,
        EDUCATION,
        SPORTS))

    val  typeFilters = _typeFilters   .asStateFlow()

    fun getPlaces(placeType: PlaceType = ALL) {
        placeRepository.getPlaces(placeType.tags)
            .map {
                mapToUiData(it)
            }.onEach{
            _placesByFilter.value =  it
        }.catch {
            it.printStackTrace()
        } .launchIn(viewModelScope)
    }

    private fun mapToUiData( placesData : List<PlaceResponse>) : List<Place> {
        val places : MutableList<Place> = mutableListOf()
        placesData.forEach { place ->
            places.add(
                Place(place.id,place.displayName.text, place.primaryType, emptyList(),
                    place.getFullImageUri(),place.rating,place.reviews,place.shortAddress)
            )
        }
       return places
    }


    fun onTypeFilterClicked(placeType: PlaceType) {
        _typeFilters.update {
            it.map {
                if(it.id == placeType.id)
                    it.copy(selected = true)
                else
                    it.copy(selected = false)
            }
        }
        _placesByFilter.value = emptyList()
        getPlaces( placeType)
    }




}