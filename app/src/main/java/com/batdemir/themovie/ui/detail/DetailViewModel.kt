package com.batdemir.themovie.ui.detail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.asFlow
import com.batdemir.themovie.core.vm.BaseViewModel
import com.batdemir.themovie.data.entities.db.Movie
import com.batdemir.themovie.data.repository.TheMovieRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val repository: TheMovieRepository
) : BaseViewModel() {
    val liveData: MutableLiveData<State> = MutableLiveData()

    fun getMovie(movieId: Long) {
        repository.getMovie(movieId).asFlow().handle(
            requestType = RequestType.INIT,
            errorType = ErrorType.SHOW,
            onComplete = {
                liveData.value = State.Init(it)
            }
        )
    }

    sealed class State {
        data class Init(val value: Movie) : State()
    }
}