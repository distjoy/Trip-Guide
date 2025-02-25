package com.tunieapps.tripguide.data

import com.tunieapps.tripguide.model.Constants.GMS_API_KEY
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow


class PlacesRepository (val placesApi: PlacesApi) {

    fun getPlaces(tags: List<String>): Flow<List<PlaceResponse>> {
       return flow {
           val response =  placesApi.getPlaces(PlacesRequestBody(types = tags, count = 10,
                constraints = LocationRestriction(Circle(Center(37.7937,-122.3965),500.0))),
               GMS_API_KEY)

           emit(response.results)
        }
    }

    fun getLikedPlaces(): Flow<List<PlaceResponse>> {
        return flow {
            val response =  placesApi.getPlaces(PlacesRequestBody(types = emptyList(), count = 10, rankBy = "POPULARITY",
                constraints = LocationRestriction(Circle(Center(37.7937,-122.3965),500.0))),
                GMS_API_KEY)

            emit(response.results)
        }
    }
}