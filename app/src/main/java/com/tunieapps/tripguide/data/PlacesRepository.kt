package com.tunieapps.tripguide.data

import com.tunieapps.tripguide.model.Constants.Companion.API_KEY
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import javax.inject.Inject


class PlacesRepository (val placesApi: PlacesApi) {

    fun getPlaces() : Flow<List<PlaceResponse>> {
       return flow {
           val response =  placesApi.getPlaces(PlacesRequestBody(types = emptyList(), count = 10,
                constraints = LocationRestriction(Circle(Center(37.7937,-122.3965),500.0))),
               API_KEY)

           emit(response.results)
        }
    }
}