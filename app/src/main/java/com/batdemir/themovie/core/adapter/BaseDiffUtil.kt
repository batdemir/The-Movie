package com.batdemir.themovie.core.adapter

import androidx.recyclerview.widget.DiffUtil
import com.batdemir.themovie.other.RecyclerItem

val BASE_DIFF_UTIL = object : DiffUtil.ItemCallback<RecyclerItem>() {
    override fun areItemsTheSame(oldItem: RecyclerItem, newItem: RecyclerItem): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: RecyclerItem, newItem: RecyclerItem): Boolean {
        return oldItem == newItem
    }
}