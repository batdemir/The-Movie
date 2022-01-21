package com.batdemir.themovie.data.entities.dto

import android.os.Parcel
import android.os.Parcelable
import com.batdemir.themovie.other.RecyclerItem

data class MovieResultDto(
    override val id: Long,
    override var isSelected: Boolean = false,
    val posterPath: String? = null,
    val title: String? = null,
    val overview: String? = null,
    val releaseDate: String? = null
) : RecyclerItem, Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readLong(),
        parcel.readByte() != 0.toByte(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeLong(id)
        parcel.writeByte(if (isSelected) 1 else 0)
        parcel.writeString(posterPath)
        parcel.writeString(title)
        parcel.writeString(overview)
        parcel.writeString(releaseDate)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<MovieResultDto> {
        override fun createFromParcel(parcel: Parcel): MovieResultDto {
            return MovieResultDto(parcel)
        }

        override fun newArray(size: Int): Array<MovieResultDto?> {
            return arrayOfNulls(size)
        }
    }
}