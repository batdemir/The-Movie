package com.batdemir.themovie.di.module

import com.batdemir.themovie.di.manager.language.MyLanguageManager
import com.batdemir.themovie.di.manager.language.MyLanguageManagerImp
import com.batdemir.themovie.di.manager.resource.MyResourceManager
import com.batdemir.themovie.di.manager.resource.MyResourceManagerImp
import com.batdemir.themovie.di.manager.storage.MyStorageManager
import com.batdemir.themovie.di.manager.storage.MyStorageManagerImp
import com.batdemir.themovie.di.manager.theme.MyThemeManager
import com.batdemir.themovie.di.manager.theme.MyThemeManagerImp
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
abstract class ManagerModule {
    @Binds
    abstract fun provideLanguage(myLanguageHandlerImp: MyLanguageManagerImp): MyLanguageManager

    @Binds
    abstract fun provideResource(resourceInitializerImp: MyResourceManagerImp): MyResourceManager

    @Binds
    abstract fun provideStorage(prefStorageManagerImp: MyStorageManagerImp): MyStorageManager

    @Binds
    abstract fun provideTheme(myThemeManagerImp: MyThemeManagerImp): MyThemeManager
}