package com.tunieapps.tripguide.data

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch

class PlacesRepository(val placesApi: PlacesApi) {

    fun getPlaces() : Flow<List<PlacesResponse>> {
       return flow {
            placesApi.getPlaces()
        }
    }
}