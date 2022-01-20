package com.batdemir.themovie.ui.home

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.batdemir.themovie.R
import com.batdemir.themovie.core.adapter.BasePagingAdapter
import com.batdemir.themovie.core.adapter.BaseViewHolder
import com.batdemir.themovie.core.adapter.BindListener
import com.batdemir.themovie.core.adapter.ItemListener
import com.batdemir.themovie.core.view.BaseActionLoadState
import com.batdemir.themovie.core.view.BaseFragment
import com.batdemir.themovie.data.entities.dto.MovieResultDto
import com.batdemir.themovie.databinding.FragmentHomeBinding
import com.batdemir.themovie.databinding.ItemMovieBinding
import com.batdemir.themovie.databinding.ItemMovieSliderBinding
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HomeFragment :
    BaseFragment<FragmentHomeBinding, HomeViewModel>(R.layout.fragment_home),
    BaseActionLoadState {
    private lateinit var settings: MenuItem
    private val viewModel: HomeViewModel by viewModels()
    private val sliderAdapter by lazy {
        BasePagingAdapter(
            layoutId = R.layout.item_movie_slider,
            bindListener = object : BindListener<MovieResultDto, ItemMovieSliderBinding> {
                override fun onBind(
                    holderBase: BaseViewHolder<ItemMovieSliderBinding>,
                    model: MovieResultDto,
                    position: Int
                ) {
                    holderBase.binding.model = model
                    holderBase.binding.executePendingBindings()
                }
            },
            itemListener = object : ItemListener<MovieResultDto> {
                override fun onClick(value: MovieResultDto) {
                    findNavController().navigate(
                        HomeFragmentDirections.actionHomeFragmentToDetailFragment(
                            value.id
                        )
                    )
                }

                override fun onLongClick(value: MovieResultDto) {
                    //("Not yet implemented")
                }
            }
        )
    }
    private val adapter by lazy {
        BasePagingAdapter(
            layoutId = R.layout.item_movie,
            bindListener = object : BindListener<MovieResultDto, ItemMovieBinding> {
                override fun onBind(
                    holderBase: BaseViewHolder<ItemMovieBinding>,
                    model: MovieResultDto,
                    position: Int
                ) {
                    holderBase.binding.model = model
                    holderBase.binding.executePendingBindings()
                }
            },
            itemListener = object : ItemListener<MovieResultDto> {
                override fun onClick(value: MovieResultDto) {
                    findNavController().navigate(
                        HomeFragmentDirections.actionHomeFragmentToDetailFragment(
                            value.id
                        )
                    )
                }

                override fun onLongClick(value: MovieResultDto) {
                    //("Not yet implemented")
                }
            }
        )
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        settings = menu.add(MENU_ITEM_SETTINGS)
        settings.setIcon(R.drawable.ic_black_settings)
        settings.setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM)
        settings.setOnMenuItemClickListener {
            findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToSettingsFragment())
            true
        }
    }

    override fun setupDefinition(savedInstanceState: Bundle?) {
        setupViewModel(viewModel)
        setHasOptionsMenu(true)
        getBinding().viewModel = viewModel
        getBinding().recyclerView.adapter = adapter
        getBinding().viewPager.adapter = sliderAdapter
    }

    override fun setupListener() {
        TabLayoutMediator(getBinding().tabLayout, getBinding().viewPager) { _, _ ->
        }.attach()
        getBinding().swipeRefreshLayout.setOnRefreshListener {
            getBinding().swipeRefreshLayout.isRefreshing = false
            setupData()
        }
        setPagingAdapterLoadStateListener(viewModel, adapter)
    }

    override fun setupData() {
        super.setupData()
        observeSlider()
        observeList()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        removePagingAdapterLoadStateListener(viewModel, adapter)
    }

    private fun observeSlider() {
        viewLifecycleOwner
            .lifecycleScope
            .launch {
                viewModel
                    .repository
                    .getMovieNowPlayings()
                    .collectLatest {
                        sliderAdapter.mySummitData(it)
                    }
            }
    }

    private fun observeList() {
        viewLifecycleOwner
            .lifecycleScope
            .launch {
                viewModel
                    .repository
                    .getMovieUpComings()
                    .collectLatest {
                        adapter.mySummitData(it)
                    }
            }
    }

    companion object {
        const val MENU_ITEM_SETTINGS = "settings"
    }
}