package com.tunieapps.tripguide.data

import com.tunieapps.tripguide.model.Constants.GMS_API_KEY
import com.tunieapps.tripguide.model.Constants.BASE_URL
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PlacesResponse(@SerialName("places") val results : List<PlaceResponse>){

    companion object{
       const val FIELDS =  "places.id,places.name,places.displayName,places.primaryType,places.formattedAddress,places.shortFormattedAddress,places.addressComponents,places.rating,places.iconMaskBaseUri,places.photos,places.userRatingCount"

    }
}
@Serializable
data class PlacesSearchStatus(val id : String)

@Serializable
data class PlaceResponse(val id : String, val name : String, val displayName : DisplayName, val primaryType : String="",@SerialName("formattedAddress") val formattedAddress : String,
    @SerialName("shortFormattedAddress") val shortAddress : String,
                         val addressComponents : List<AddressComponents>, val rating : Double,
                         @SerialName("iconMaskBaseUri") val icon : String, val photos : List<Photo>,
                         @SerialName("userRatingCount")val reviews : Int){
    fun getFullImageUri() : String{
        return "$BASE_URL/v1/${photos[0].name}/media?maxHeightPx=400&maxWidthPx=400&key=$GMS_API_KEY"
    }
}

@Serializable
data class DisplayName( val text : String,
                            val languageCode : String)
@Serializable
data class AddressComponents(@SerialName("longText") val longName : String,
                             @SerialName("shortText") val shortName : String,val types : List<String>,
            val languageCode : String)

@Serializable
data class Photo( val name : String, val widthPx : Int, val heightPx : Int, val authorAttributions : List<AuthorAttributions>, val flagContentUri : String, val  googleMapsUri : String)

@Serializable
data class AuthorAttributions(val displayName : String, val uri : String,val photoUri : String)
