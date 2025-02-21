package com.tunieapps.tripguide.model

data class Place(val id : String, val displayName : String,val primaryType : String,
                 val type : List<PlaceType>, val photo : String, val ratings : Double, val reviews : Int, val address : String )

data class PlaceType(val id : String, val displayName : String, val tags : List<String>)
