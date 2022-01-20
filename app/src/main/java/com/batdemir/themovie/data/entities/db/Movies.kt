package com.batdemir.themovie.data.entities.db

import com.google.gson.annotations.SerializedName

data class Movies(
    val dates: Dates? = null,
    val page: Int? = null,
    val results: List<MovieResult>? = null,
    @SerializedName("total_pages")
    val totalPages: Long? = null,
    @SerializedName("total_results")
    val totalResults: Long? = null
)