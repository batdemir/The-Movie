package com.batdemir.themovie.di.module.remote

import com.batdemir.themovie.data.remote.datasource.TheMovieRemoteDataSource
import com.batdemir.themovie.data.remote.service.TheMovieService
import com.batdemir.themovie.di.manager.language.MyLanguageManager
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
object RemoteDataSourceModule {
    @Provides
    fun provideRemoteDataSourceTheMovie(
        myLanguageManager: MyLanguageManager,
        service: TheMovieService
    ) =
        TheMovieRemoteDataSource(myLanguageManager, service)
}