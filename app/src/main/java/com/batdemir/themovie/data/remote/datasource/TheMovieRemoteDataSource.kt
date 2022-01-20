package com.batdemir.themovie.data.remote.datasource

import com.batdemir.themovie.BuildConfig
import com.batdemir.themovie.data.remote.base.BaseDataSource
import com.batdemir.themovie.data.remote.service.TheMovieService
import javax.inject.Inject

class TheMovieRemoteDataSource @Inject constructor(
    private val service: TheMovieService
) : BaseDataSource() {
    suspend fun getMovieNowPlayings(
        language: String? = null,
        page: Long? = null,
        region: String? = null,
    ) = getResult { service.getMovieNowPlayings(BuildConfig.API_KEY, language, page, region) }

    suspend fun getMovieUpComings(
        language: String? = null,
        page: Long? = null,
        region: String? = null,
    ) = getResult { service.getMovieUpComings(BuildConfig.API_KEY, language, page, region) }

    suspend fun getMovie(
        movieId: Int,
        language: String? = null,
        appendToResponse: String? = null,
    ) = getResult { service.getMovie(movieId, BuildConfig.API_KEY, language, appendToResponse) }
}