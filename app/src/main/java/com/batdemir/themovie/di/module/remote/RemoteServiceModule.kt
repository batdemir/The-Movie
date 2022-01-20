package com.batdemir.themovie.di.module.remote

import com.batdemir.themovie.BuildConfig
import com.batdemir.themovie.data.remote.service.TheMovieService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Converter
import retrofit2.Retrofit

@InstallIn(SingletonComponent::class)
@Module
object RemoteServiceModule {
    @Provides
    fun provideTheMovieService(
        builder: Retrofit.Builder,
        converterFactory: Converter.Factory,
        client: OkHttpClient
    ): TheMovieService {
        return builder
            .baseUrl(BuildConfig.API)
            .addConverterFactory(converterFactory)
            .client(client)
            .build()
            .create(TheMovieService::class.java)
    }
}