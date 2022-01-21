package com.batdemir.themovie.data.entities.dto

import android.os.Parcel
import android.os.Parcelable
import com.batdemir.themovie.other.RecyclerItem

data class MovieDto(
    override val id: Long,
    override var isSelected: Boolean = false,
    val posterPath: String? = null,
    val voteAverage: String? = null,
    val releaseDate: String? = null,
    val title: String? = null,
    val overview: String? = null,
    val imdbId: String? = null,
) : RecyclerItem, Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readLong(),
        parcel.readByte() != 0.toByte(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeLong(id)
        parcel.writeByte(if (isSelected) 1 else 0)
        parcel.writeString(posterPath)
        parcel.writeString(voteAverage)
        parcel.writeString(releaseDate)
        parcel.writeString(title)
        parcel.writeString(overview)
        parcel.writeString(imdbId)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<MovieDto> {
        override fun createFromParcel(parcel: Parcel): MovieDto {
            return MovieDto(parcel)
        }

        override fun newArray(size: Int): Array<MovieDto?> {
            return arrayOfNulls(size)
        }
    }
}