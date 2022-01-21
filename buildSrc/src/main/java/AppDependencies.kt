@file:Suppress("SpellCheckingInspection")

object AppDependencies {
    val appLibraries = arrayListOf<String>().apply {
        add("androidx.appcompat:appcompat:${Versions.androidxAppCompatVersion}")
        add("androidx.arch.core:core-runtime:${Versions.androidxArchCoreVersion}")
        add("androidx.constraintlayout:constraintlayout:${Versions.androidxConstraintLayoutVersion}")
        add("androidx.core:core-ktx:${Versions.androidxCoreVersion}")
        add("androidx.fragment:fragment-ktx:${Versions.androidxFragmentVersion}")
        add("androidx.legacy:legacy-support-v4:${Versions.androidxLegacySupportVersion}")
        add("androidx.lifecycle:lifecycle-common-java8:${Versions.androidxLifeCycleCommonVersion}")
        add("androidx.lifecycle:lifecycle-extensions:${Versions.androidxLifeCycleExtensionsVersion}")
        add("androidx.lifecycle:lifecycle-livedata-ktx:${Versions.androidxLifeCycleLiveDataVersion}")
        add("androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.androidxLifeCycleViewModelVersion}")
        add("androidx.lifecycle:lifecycle-viewmodel-savedstate:${Versions.androidxLifeCycleStateVersion}")
        add("androidx.navigation:navigation-compose:${Versions.androidxNavigationVersion}")
        add("androidx.navigation:navigation-dynamic-features-fragment:${Versions.androidxNavigationVersion}")
        add("androidx.navigation:navigation-fragment-ktx:${Versions.androidxNavigationVersion}")
        add("androidx.navigation:navigation-ui-ktx:${Versions.androidxNavigationVersion}")
        add("androidx.paging:paging-guava:${Versions.androidxPagingVersion}")
        add("androidx.paging:paging-runtime-ktx:${Versions.androidxPagingVersion}")
        add("androidx.preference:preference-ktx:${Versions.androidxPreferenceVersion}")
        add("androidx.room:room-ktx:${Versions.androidxRoomVersion}")
        add("androidx.room:room-runtime:${Versions.androidxRoomVersion}")
        add("androidx.startup:startup-runtime:${Versions.androidxStartUpVersion}")
        add("androidx.viewpager2:viewpager2:${Versions.androidxViewPagerVersion}")
        add("com.github.bumptech.glide:glide:${Versions.githubGlideVersion}")
        add("com.github.bumptech.glide:okhttp3-integration:${Versions.githubGlideVersion}")
        add("com.github.YarikSOffice:lingver:${Versions.githubLingverVersion}")
        add("com.github.PhilJay:MPAndroidChart:${Versions.githubMPAndroidChartVersion}")
        add("com.google.dagger:hilt-android:${Versions.googleHiltVersion}")
        add("com.jakewharton.timber:timber:${Versions.timberVersion}")
        add("org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.jetBrainsCoroutinesVersion}")
        add("org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.jetBrainsCoroutinesVersion}")
        add("com.squareup.retrofit2:retrofit:${Versions.squareupRetrofitVersion}")
        add("com.squareup.retrofit2:converter-gson:${Versions.squareupRetrofitVersion}")
        add("com.squareup.okhttp3:okhttp:${Versions.squareupOkHttpVersion}")
        add("com.squareup.okhttp3:logging-interceptor:${Versions.squareupOkHttpVersion}")
    }

    val testLibraries = arrayListOf<String>().apply {
        add("com.google.truth:truth:${Versions.testGoogleTruthVersion}")
        add("junit:junit:${Versions.testJunitVersion}")
    }

    val androidTestLibraries = arrayListOf<String>().apply {
        add("androidx.arch.core:core-testing:${Versions.androidxArchCoreVersion}")
        add("androidx.test.espresso:espresso-core:${Versions.testAndroidxTestEspresso}")
        add("androidx.test.ext:junit-ktx:${Versions.testAndroidxTestJunitVersion}")
        add("com.google.dagger:hilt-android-testing:${Versions.googleHiltVersion}")
        add("com.google.truth:truth:${Versions.testGoogleTruthVersion}")
        add("org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.testJetBrainsCoroutinesVersion}")
    }

    val compilerLibraries = arrayListOf<String>().apply {
        add("androidx.room:room-compiler:${Versions.androidxRoomVersion}")
        add("com.github.bumptech.glide:compiler:${Versions.githubGlideVersion}")
        add("com.google.dagger:hilt-android-compiler:${Versions.googleHiltVersion}")
    }

    val compilerTestLibraries = arrayListOf<String>().apply {
    }

    val compilerAndroidTestLibraries = arrayListOf<String>().apply {
        add("com.google.dagger:hilt-android-compiler:${Versions.googleHiltVersion}")
    }

    val debugLibraries = arrayListOf<String>().apply {
        add("com.readystatesoftware.chuck:library:${Versions.chuckVersion}")
    }

    val releaseLibraries = arrayListOf<String>().apply {
        add("com.readystatesoftware.chuck:library-no-op:${Versions.chuckVersion}")
    }
}