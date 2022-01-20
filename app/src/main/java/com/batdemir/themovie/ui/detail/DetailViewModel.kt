package com.batdemir.themovie.ui.detail

import android.net.Uri
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.asFlow
import com.batdemir.themovie.core.vm.BaseViewModel
import com.batdemir.themovie.data.entities.db.toDto
import com.batdemir.themovie.data.entities.dto.MovieDto
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
                liveData.value = State.Init(it.toDto())
            }
        )
    }

    fun clickIMDB(imdbId: String?) {
        imdbId?.let {
            liveData.value = State.ClickedIMDB(uri = Uri.parse("$IMDB_URL$imdbId"))
        }
    }

    sealed class State {
        data class Init(val value: MovieDto) : State()
        data class ClickedIMDB(val uri: Uri) : State()
    }

    companion object {
        const val IMDB_URL = "https://imdb.com/title/"
    }
}