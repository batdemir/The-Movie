package com.batdemir.themovie.core.adapter

import androidx.databinding.ViewDataBinding
import com.batdemir.themovie.other.RecyclerItem

interface BindListener<T : RecyclerItem, V : ViewDataBinding> {
    fun onBind(holderBase: BaseViewHolder<V>, model: T, position: Int)
}