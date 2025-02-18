package com.tunieapps.tripguide.data

data class PlacesResponse(val results : List<PlaceResponse>, val status : PlacesSearchStatus, val error : String,
    val info : List<String>)

data class PlacesSearchStatus(val id : String)

data class PlaceResponse(val id : String, val name : String, val address : String, val addressComponents : List<AddressComponents>, val rating : Double,
    val icon : String, val photos : List<String>, val reviews : Int)

data class AddressComponents(val longName : String, val shortName : String,val types : List<String>)