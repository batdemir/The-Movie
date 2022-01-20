package com.batdemir.themovie.ui.detail

import android.os.Bundle
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.batdemir.themovie.R
import com.batdemir.themovie.core.view.BaseFragment
import com.batdemir.themovie.databinding.FragmentDetailBinding
import com.batdemir.themovie.utils.observe
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailFragment :
    BaseFragment<FragmentDetailBinding, DetailViewModel>(R.layout.fragment_detail) {
    private val viewModel: DetailViewModel by viewModels()
    private val args: DetailFragmentArgs by navArgs()

    override fun setupDefinition(savedInstanceState: Bundle?) {
        setupViewModel(viewModel)
    }

    override fun setupData() {
        super.setupData()
        observe(viewModel.liveData, ::onStateChanged)
        viewModel.getMovie(args.movieId)
    }

    override fun setupListener() {
        //("Not yet implemented")
    }

    private fun onStateChanged(state: DetailViewModel.State) {
        when (state) {
            is DetailViewModel.State.Init -> {
                getBinding().model = state.value
                getBinding().executePendingBindings()
            }
        }
    }
}