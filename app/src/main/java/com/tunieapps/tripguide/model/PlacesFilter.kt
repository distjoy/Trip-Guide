package com.tunieapps.tripguide.model

sealed class PlacesFilter (val filterString : String = "All"){
    object All : PlacesFilter()
    data object Entertainment : PlacesFilter("Recommended")

}