package com.batdemir.themovie.core.adapter

import com.batdemir.themovie.other.RecyclerItem

interface ItemListener<T : RecyclerItem> {
    fun onClick(value: T)
    fun onLongClick(value: T)
}