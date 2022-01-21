package com.batdemir.themovie.ui.settings

import com.batdemir.themovie.BuildConfig
import com.batdemir.themovie.core.vm.BaseViewModel
import com.batdemir.themovie.di.manager.language.Languages
import com.batdemir.themovie.di.manager.language.MyLanguageManager
import com.batdemir.themovie.di.manager.resource.MyResourceManager
import com.batdemir.themovie.di.manager.theme.MyThemeManager
import com.batdemir.themovie.di.manager.theme.Themes
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SettingsViewModel @Inject constructor(
    private val myLanguageManager: MyLanguageManager,
    private val myThemeManager: MyThemeManager,
    private val myResourceManager: MyResourceManager
) : BaseViewModel() {
    fun changeLanguage(newValue: String) {
        myLanguageManager.changeLanguage(
            Languages.values()
                .first { x ->
                    myResourceManager.getResources()
                        .getString(x.languageName) == newValue
                }
        )
    }

    fun changeTheme(newValue: String) {
        myThemeManager.changeTheme(
            Themes.values()
                .first { x ->
                    myResourceManager.getResources()
                        .getString(x.themeName) == newValue
                }
        )
    }

    fun getVersionName(): String =
        BuildConfig.VERSION_NAME

    fun getLanguageResId(): Int =
        myLanguageManager.getCurrentLanguage().languageName

    fun getThemeResId(): Int =
        myThemeManager.getCurrentTheme().themeName
}