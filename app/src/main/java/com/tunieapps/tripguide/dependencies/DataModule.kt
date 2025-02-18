package com.tunieapps.tripguide.dependencies

import com.tunieapps.tripguide.data.PlacesApi
import com.tunieapps.tripguide.data.PlacesRepository
import dagger.Provides
import retrofit2.Retrofit

class DataModule {

    @Provides
    fun providesPlacesRepo(placesApi: PlacesApi) : PlacesRepository {
        return PlacesRepository(placesApi)
    }

    @Provides
    fun providesPlacesApi(retrofit : Retrofit) : PlacesApi {
      return  retrofit.create(PlacesApi::class.java)
    }
}