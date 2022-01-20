package com.batdemir.themovie.data.entities.db

import com.google.gson.annotations.SerializedName

data class ProductionCountry(
    @SerializedName("iso_3166_1")
    val iso31661: String? = null,
    val name: String? = null
)