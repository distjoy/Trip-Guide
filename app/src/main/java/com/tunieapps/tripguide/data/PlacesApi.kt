package com.tunieapps.tripguide.data

import retrofit2.http.GET

interface PlacesApi {

    @GET("places")
    suspend fun getPlaces() : List<PlacesResponse>

    suspend fun getDistance()
}