package com.batdemir.themovie.di.module

import com.batdemir.themovie.data.remote.datasource.TheMovieRemoteDataSource
import com.batdemir.themovie.data.repository.TheMovieRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
object RepositoryModule {
    @Provides
    fun provideRepositoryTheMovie(
        remoteDataSource: TheMovieRemoteDataSource
    ) = TheMovieRepository(remoteDataSource)
}