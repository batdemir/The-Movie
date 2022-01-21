package com.batdemir.themovie.data.entities.db

import com.batdemir.themovie.BuildConfig
import com.batdemir.themovie.data.entities.dto.MovieResultDto
import com.batdemir.themovie.utils.DateFormat
import com.batdemir.themovie.utils.toDateFormat
import com.google.gson.annotations.SerializedName

data class MovieResult(
    val adult: Boolean? = null,
    @SerializedName("backdrop_path")
    val backdropPath: String? = null,
    @SerializedName("genre_ids")
    val genreIds: List<Int>? = null,
    val id: Long = 0,
    @SerializedName("original_language")
    val originalLanguage: String? = null,
    @SerializedName("original_title")
    val originalTitle: String? = null,
    val overview: String? = null,
    val popularity: Double? = null,
    @SerializedName("poster_path")
    val posterPath: String? = null,
    @SerializedName("release_date")
    val releaseDate: String? = null,
    val title: String? = null,
    val video: Boolean? = null,
    @SerializedName("vote_average")
    val voteAverage: Double? = null,
    val voteCount: Int? = null,
)

fun MovieResult.toDto(): MovieResultDto {
    return MovieResultDto(
        id = this.id,
        isSelected = false,
        posterPath = BuildConfig.CDN_API + this.posterPath,
        title = this.title,
        overview = this.overview,
        releaseDate = this.releaseDate?.toDateFormat(
            DateFormat.SMALL_DATE_FORMAT,
            DateFormat.SHOW_DATE_FORMAT
        ),
    )
}