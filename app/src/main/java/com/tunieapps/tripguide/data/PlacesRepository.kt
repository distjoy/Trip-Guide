package com.tunieapps.tripguide.data

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import javax.inject.Inject


class PlacesRepository (val placesApi: PlacesApi) {

    fun getPlaces() : Flow<List<PlacesResponse>> {
       return flow {
            placesApi.getPlaces(PlacesRequestBody(types = emptyList(), count = 10, constraints = LocationRestriction(Circle(Center(37.7937,-122.3965),500.0))),"")
        }
    }
}