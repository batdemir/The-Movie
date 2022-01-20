package com.batdemir.themovie.data.entities.db

import com.batdemir.themovie.BuildConfig
import com.batdemir.themovie.data.entities.dto.MovieDto
import com.batdemir.themovie.utils.DateFormat
import com.batdemir.themovie.utils.toDateFormat
import com.google.gson.annotations.SerializedName

data class Movie(
    val adult: Boolean? = null,
    @SerializedName("backdrop_path")
    val backdropPath: String? = null,
    @SerializedName("belongs_to_collection")
    val belongsToCollection: Any? = null,
    val budget: Int? = null,
    val genres: List<Genre>? = null,
    val homepage: String? = null,
    val id: Long = 0,
    @SerializedName("imdb_id")
    val imdbId: String? = null,
    @SerializedName("original_language")
    val originalLanguage: String? = null,
    @SerializedName("original_title")
    val originalTitle: String? = null,
    val overview: String? = null,
    val popularity: Double? = null,
    @SerializedName("poster_path")
    val posterPath: String? = null,
    @SerializedName("production_companies")
    val productionCompanies: List<ProductionCompany>? = null,
    @SerializedName("production_countries")
    val productionCountries: List<ProductionCountry>? = null,
    @SerializedName("release_date")
    val releaseDate: String? = null,
    val revenue: Int? = null,
    val runtime: Int? = null,
    @SerializedName("spoken_languages")
    val spokenLanguages: List<SpokenLanguage>? = null,
    val status: String? = null,
    val tagline: String? = null,
    val title: String? = null,
    val video: Boolean? = null,
    @SerializedName("vote_average")
    val voteAverage: Double? = null,
    @SerializedName("vote_count")
    val voteCount: Int? = null
)

fun Movie.toDto(): MovieDto {
    return MovieDto(
        id = this.id,
        isSelected = false,
        posterPath = BuildConfig.CDN_API + this.posterPath,
        voteAverage = String.format("%.1f", this.voteAverage ?: 0f),
        releaseDate = this.releaseDate?.toDateFormat(
            DateFormat.SMALL_DATE_FORMAT,
            DateFormat.SHOW_DATE_FORMAT
        ),
        title = this.title,
        overview = this.overview,
        imdbId = this.imdbId
    )
}