package com.batdemir.themovie.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.batdemir.themovie.data.entities.db.MovieResult
import com.batdemir.themovie.data.paging.MovieType
import com.batdemir.themovie.data.paging.TheMoviePagingRemoteDatasource
import com.batdemir.themovie.data.remote.datasource.TheMovieRemoteDataSource
import com.batdemir.themovie.other.Constant
import com.batdemir.themovie.utils.performGetOperation
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class TheMovieRepository @Inject constructor(
    private val remoteDataSource: TheMovieRemoteDataSource
) {
    fun getMovieNowPlayings(): Flow<PagingData<MovieResult>> = Pager(
        config = PagingConfig(pageSize = Constant.NETWORK_PAGE_SIZE, enablePlaceholders = false),
        pagingSourceFactory = {
            TheMoviePagingRemoteDatasource(
                remoteDataSource,
                MovieType.NOW_PLAYING
            )
        }
    ).flow

    fun getMovieUpComings(): Flow<PagingData<MovieResult>> = Pager(
        config = PagingConfig(pageSize = Constant.NETWORK_PAGE_SIZE, enablePlaceholders = false),
        pagingSourceFactory = {
            TheMoviePagingRemoteDatasource(
                remoteDataSource,
                MovieType.UP_COMING
            )
        }
    ).flow

    fun getMovie(movieId: Long) =
        performGetOperation(networkCall = { remoteDataSource.getMovie(movieId) })
}