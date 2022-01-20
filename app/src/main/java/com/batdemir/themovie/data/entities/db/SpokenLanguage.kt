package com.batdemir.themovie.data.entities.db

import com.google.gson.annotations.SerializedName

data class SpokenLanguage(
    @SerializedName("iso_639_1")
    val iso6391: String? = null,
    val name: String? = null
)