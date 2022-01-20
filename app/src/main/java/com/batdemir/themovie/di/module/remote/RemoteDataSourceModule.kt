package com.batdemir.themovie.di.module.remote

import com.batdemir.themovie.data.remote.datasource.TheMovieRemoteDataSource
import com.batdemir.themovie.data.remote.service.TheMovieService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
object RemoteDataSourceModule {
    @Provides
    fun provideRemoteDataSourceTheMovie(service: TheMovieService) =
        TheMovieRemoteDataSource(service)
}