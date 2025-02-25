package com.tunieapps.tripguide.model

import com.tunieapps.tripguide.R

data class Place(val id : String, val displayName : String,val primaryType : String,
                 val type : List<PlaceType>, val photo : String, val ratings : Double, val reviews : Int, val address : String )

data class PlaceType(val id : String="", val displayName : String="",val icon : Int = 0, val tags : List<String> = emptyList(), val selected : Boolean = false)
 val ALL = PlaceType("1","All", R.drawable.menu, emptyList(),true)
val RESTAURANTS  =  PlaceType("2","Restaurants",R.drawable.reserve, listOf("cafe","restaurant"))
val PARKS  =  PlaceType("3","Parks",R.drawable.tree, listOf("park","amusement_park"))
val   ENTERTAINMENT  =  PlaceType("4","Entertainment",R.drawable.game, listOf("casino","movie_theater","night_club"))
val   HOTELS  =  PlaceType ("5","Hotels",R.drawable.reserve, listOf("motel","lodging"))
val  EDUCATION  =  PlaceType ("6","Education",R.drawable.reserve, emptyList())
val  SPORTS  =  PlaceType("7","Sports",R.drawable.reserve, emptyList())


