package com.batdemir.themovie.core.view

import android.os.Bundle

interface BaseAction {
    fun setupDefinition(savedInstanceState: Bundle?)
    fun setupData()
    fun setupListener()
}