package com.tunieapps.tripguide.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class  PlacesRequestBody (@SerialName("includedTypes")  val types : List<String>,
                               @SerialName("maxResultCount") val count: Int ,
                               @SerialName("locationRestriction") val constraints: LocationRestriction)

@Serializable
data class LocationRestriction(@SerialName("circle")  val location : Circle)

@Serializable
data class Circle( val center : Center, val radius : Double)
@Serializable
data class Center(val latitude : Double, val longitude : Double)