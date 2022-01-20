package com.batdemir.themovie.data.remote.service

import com.batdemir.themovie.data.entities.db.Movie
import com.batdemir.themovie.data.entities.db.Movies
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface TheMovieService {
    @GET("/3/movie/now_playing")
    suspend fun getMovieNowPlayings(
        @Query("api_key") apiKey: String,
        @Query("language") language: String? = null,
        @Query("page") page: Long? = null,
        @Query("region") region: String? = null,
    ): Response<Movies>

    @GET("/3/movie/upcoming")
    suspend fun getMovieUpComings(
        @Query("api_key") apiKey: String,
        @Query("language") language: String? = null,
        @Query("page") page: Long? = null,
        @Query("region") region: String? = null,
    ): Response<Movies>

    @GET("/3/movie/upcoming/{movie_id}")
    suspend fun getMovie(
        @Path("movie_id") movieId: Int,
        @Query("api_key") apiKey: String,
        @Query("language") language: String? = null,
        @Query("append_to_response") appendToResponse: String? = null,
    ): Response<Movie>
}