package com.batdemir.themovie.data.remote.datasource

import com.batdemir.themovie.BuildConfig
import com.batdemir.themovie.data.remote.base.BaseDataSource
import com.batdemir.themovie.data.remote.service.TheMovieService
import com.batdemir.themovie.di.manager.language.MyLanguageManager
import javax.inject.Inject

class TheMovieRemoteDataSource @Inject constructor(
    private val myLanguageManager: MyLanguageManager,
    private val service: TheMovieService
) : BaseDataSource() {
    suspend fun getMovieNowPlayings(
        page: Long? = null,
        region: String? = null,
    ) = getResult {
        service.getMovieNowPlayings(
            BuildConfig.API_KEY,
            myLanguageManager.getCurrentLanguage().languageCode,
            page,
            region
        )
    }

    suspend fun getMovieUpComings(
        page: Long? = null,
        region: String? = null,
    ) = getResult {
        service.getMovieUpComings(
            BuildConfig.API_KEY,
            myLanguageManager.getCurrentLanguage().languageCode,
            page,
            region
        )
    }

    suspend fun getMovie(
        movieId: Long,
        appendToResponse: String? = null,
    ) = getResult {
        service.getMovie(
            movieId,
            BuildConfig.API_KEY,
            myLanguageManager.getCurrentLanguage().languageCode,
            appendToResponse
        )
    }
}