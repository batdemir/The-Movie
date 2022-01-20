package com.batdemir.themovie.ui.home

import com.batdemir.themovie.core.vm.BaseViewModel
import com.batdemir.themovie.data.repository.TheMovieRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    val repository: TheMovieRepository
) : BaseViewModel()