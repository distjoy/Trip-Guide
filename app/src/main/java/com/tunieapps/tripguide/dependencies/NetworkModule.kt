package com.tunieapps.tripguide.dependencies

import com.tunieapps.tripguide.model.Constants.Companion.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.kotlinx.serialization.asConverterFactory
import java.time.Duration

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Provides
    fun providesOkhttp() : OkHttpClient{
      val logger =   HttpLoggingInterceptor ()
        logger.level = HttpLoggingInterceptor.Level.BODY
       return OkHttpClient.Builder()
            .addNetworkInterceptor(logger)
            .callTimeout(Duration.ofSeconds(30))
            .build()

    }

    @Provides
    fun providesRetrofit(okHttpClient: OkHttpClient) : Retrofit{
        return Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(BASE_URL)
            .addConverterFactory(Json.asConverterFactory("application/json; charset=UTF8".toMediaType()))
            .build()

    }
}