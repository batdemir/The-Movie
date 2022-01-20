package com.batdemir.themovie.ui.home

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.batdemir.themovie.R
import com.batdemir.themovie.core.view.BaseFragment
import com.batdemir.themovie.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment :
    BaseFragment<FragmentHomeBinding, HomeViewModel>(R.layout.fragment_home) {
    private lateinit var settings: MenuItem
    private val viewModel: HomeViewModel by viewModels()

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
    }

    override fun setupListener() {
        //("Not yet implemented")
    }

    companion object {
        const val MENU_ITEM_SETTINGS = "settings"
    }
}