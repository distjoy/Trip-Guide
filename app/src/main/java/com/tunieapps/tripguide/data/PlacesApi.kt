package com.tunieapps.tripguide.data

import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.POST

interface PlacesApi {

    @POST("/v1/places:searchNearby")
    @Headers("X-Goog-FieldMask: ${PlacesResponse.FIELDS}")
    suspend fun getPlaces(@Body placesRequestBody: PlacesRequestBody,@Header("X-Goog-Api-Key") apiKey : String) : List<PlacesResponse>

    suspend fun getDistance()
}