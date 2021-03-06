///*
// * Designed and developed by 2021 Batuhan Demir
// *
// * Licensed under the Apache License, Version 2.0 (the "License");
// * you may not use this file except in compliance with the License.
// * You may obtain a copy of the License at
// *
// * http://www.apache.org/licenses/LICENSE-2.0
// *
// * Unless required by applicable law or agreed to in writing, software
// * distributed under the License is distributed on an "AS IS" BASIS,
// * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// * See the License for the specific language governing permissions and
// * limitations under the License.
plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
    id("androidx.navigation.safeargs.kotlin")
}

val buildType: BuildType = BuildType.RELEASE
val apiTypeName: String = "String"
val cdnApi: String = "CDN_API"
val api: String = "API"
val apiKey: String = "API_KEY"

android {
    compileSdk = AppConfig.compileSdk
    defaultConfig {
        applicationId = AppConfig.applicationId
        minSdk = AppConfig.minSdk
        targetSdk = AppConfig.targetSdk
        versionCode = AppConfig.versionCode
        versionName = AppConfig.versionName
        testInstrumentationRunner = AppConfig.androidTestInstrumentation
        signingConfig = signingConfigs.getByName("debug")
    }
    buildFeatures {
        dataBinding = true
    }
    buildTypes.all {
        when (buildType) {
            BuildType.DEBUG -> {
                this.buildConfigField(
                    apiTypeName,
                    cdnApi,
                    properties["CDN_API"].toString()
                )
                this.buildConfigField(
                    apiTypeName,
                    api,
                    properties["TEST_API"].toString()
                )
                this.buildConfigField(
                    apiTypeName,
                    apiKey,
                    properties["TEST_API_KEY"].toString()
                )
                this.resValue(
                    "string",
                    "app_name",
                    getAppName(buildType)
                )
            }
            BuildType.RELEASE -> {
                this.buildConfigField(
                    apiTypeName,
                    cdnApi,
                    properties["CDN_API"].toString()
                )
                this.buildConfigField(
                    apiTypeName,
                    api,
                    properties["PROD_API"].toString()
                )
                this.buildConfigField(
                    apiTypeName,
                    apiKey,
                    properties["PROD_API_KEY"].toString()
                )
                this.resValue(
                    "string",
                    "app_name",
                    getAppName(buildType)
                )
                isMinifyEnabled = true
                isShrinkResources = true
                proguardFiles(
                    getDefaultProguardFile("proguard-android-optimize.txt"),
                    "proguard-rules.pro"
                )
            }
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
}

dependencies {
    implementation(
        fileTree(
            mapOf(
                "dir" to "libs",
                "include" to listOf("*.jar")
            )
        )
    )
    implementation(AppDependencies.appLibraries)
    testImplementation(AppDependencies.testLibraries)
    androidTestImplementation(AppDependencies.androidTestLibraries)
    kapt(AppDependencies.compilerLibraries)
    kaptTest(AppDependencies.compilerTestLibraries)
    kaptAndroidTet(AppDependencies.compilerAndroidTestLibraries)
    debugImplementation(AppDependencies.debugLibraries)
    releaseImplementation(AppDependencies.releaseLibraries)
}

enum class BuildType(val value: String) {
    DEBUG("debug"),
    RELEASE("release")
}

fun getAppName(buildType: BuildType): String {
    val appName = "The Movie"
    return when (buildType) {
        BuildType.DEBUG -> "$appName - Debug"
        BuildType.RELEASE -> appName
    }
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = freeCompilerArgs + "-Xopt-in=kotlin.RequiresOptIn"
    }
}