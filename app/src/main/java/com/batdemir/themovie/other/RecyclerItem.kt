package com.batdemir.themovie.other

interface RecyclerItem {
    val id: Long
    var isSelected: Boolean
    override fun equals(other: Any?): Boolean
}