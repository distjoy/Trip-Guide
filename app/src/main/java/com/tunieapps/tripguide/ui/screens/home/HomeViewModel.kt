package com.tunieapps.tripguide.ui.screens.home

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tunieapps.tripguide.R
import com.tunieapps.tripguide.data.PlacesRepository
import com.tunieapps.tripguide.model.Place
import com.tunieapps.tripguide.model.PlaceType
import com.tunieapps.tripguide.model.PlacesFilter
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(val placeRepository: PlacesRepository) : ViewModel(){

    private val _places = MutableStateFlow(listOf<Place>())

    val places = _places as StateFlow<List<Place>>

    val _typeFilters = MutableStateFlow( listOf(PlaceType("1","All", R.drawable.menu, emptyList(),true),
        PlaceType("2","Restaurants",R.drawable.reserve, emptyList()),
        PlaceType("3","Parks", R.drawable.tree, emptyList()),
        PlaceType("4","Entertainment",R.drawable.game, emptyList()),
        PlaceType("5","Hotels",R.drawable.game , emptyList()),
        PlaceType("6","Education",R.drawable.game , emptyList()),
        PlaceType("7","Sports",R.drawable.game , emptyList())))

    val  typeFilters = _typeFilters   .asStateFlow()

    fun getPlaces(placesFilter: PlacesFilter = PlacesFilter.All) {
        placeRepository.getPlaces()
            .map {
                val places : MutableList<Place> = mutableListOf()
                it.forEach { place ->
                    places.add(
                      Place(place.id,place.displayName.text, place.primaryType, emptyList(),
                          place.getFullImageUri(),place.rating,place.reviews,place.shortAddress)
                    )
                }
                places
            }.onEach{
            _places.value =  it
        }.catch {
            it.printStackTrace()
        } .launchIn(viewModelScope)
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
    }




}