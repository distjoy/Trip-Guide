package com.tunieapps.tripguide.dependencies

import com.tunieapps.tripguide.data.PlacesApi
import com.tunieapps.tripguide.data.PlacesRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit


@Module
@InstallIn(SingletonComponent::class)
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