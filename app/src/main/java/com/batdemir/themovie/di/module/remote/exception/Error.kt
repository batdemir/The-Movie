package com.batdemir.themovie.di.module.remote.exception

data class Error(
    override val message: String? = null
) : Throwable() {
    override fun toString(): String {
        return message ?: ""
    }
}