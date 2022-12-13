/**
 * All dependency versions used
 */
object DependencyVersions {
    const val androidxCore = "1.8.0"
    const val androidxAppCompat = "1.3.1"
    const val composeVersion = "1.2.0"
    const val androidxLifecycle = "2.5.1"
    const val androidMaterial = "1.4.0"
    const val activityCompose = "1.4.0"
    const val jUnitVersion = "4.13.2"
    const val androidxJunit = "1.1.3"
    const val androidxEspresso = "3.3.0"
    const val kotlinCompilerExtension = "1.3.2"
    const val daggerHilt = "2.44.2"
    const val buildGradle = "7.3.0"
    const val kotlinGradlePlugin = "1.7.20"
    const val okHttpVersion = "4.9.2"
    const val timber = "5.0.1"
    const val mockk = "1.12.1"
    const val coroutine = "1.6.1"
    const val retrofit = "2.9.0"
    const val retrofitMoshiConverter = "2.4.0"
    const val coil = "2.2.2"
    const val navigatioNCompose = "2.5.0"
    const val hiltNavigationCompose = "1.0.0"
}

/**
 * List of dependencies added in the project by context
 */
sealed class Dependencies {
    object DependencyInjection {
        const val daggerHilt = "com.google.dagger:hilt-android:${DependencyVersions.daggerHilt}"
        const val daggerHiltCompiler =
            "com.google.dagger:hilt-android-compiler:${DependencyVersions.daggerHilt}"
        const val jetpackHiltCompiler =
            "com.google.dagger:hilt-compiler:${DependencyVersions.daggerHilt}"
    }

    object AndroidLifecycle {
        const val viewModelCompose =
            "androidx.lifecycle:lifecycle-viewmodel-compose:${DependencyVersions.androidxLifecycle}"
        const val runtimeKtx =
            "androidx.lifecycle:lifecycle-runtime-ktx:${DependencyVersions.androidxLifecycle}"
    }

    object JetpackUi {
        const val appCompat = "androidx.appcompat:appcompat:${DependencyVersions.androidxAppCompat}"
        const val material =
            "com.google.android.material:material:${DependencyVersions.androidMaterial}"
    }

    object JetpackCompose {
        const val androidxCore = "androidx.core:core-ktx:${DependencyVersions.androidxCore}"
        const val ui = "androidx.compose.ui:ui:${DependencyVersions.composeVersion}"
        const val material =
            "androidx.compose.material:material:${DependencyVersions.composeVersion}"
        const val uiToolingPreview =
            "androidx.compose.ui:ui-tooling-preview:${DependencyVersions.composeVersion}"
        const val composeUiTooling =
            "androidx.compose.ui:ui-tooling:${DependencyVersions.composeVersion}"
        const val activityCompose =
            "androidx.activity:activity-compose:${DependencyVersions.activityCompose}"
        const val navigationCompose =
            "androidx.navigation:navigation-compose:${DependencyVersions.navigatioNCompose}"
        const val hiltNavigationCompose =
            "androidx.hilt:hilt-navigation-compose:${DependencyVersions.hiltNavigationCompose}"
    }

    object Tests {
        const val jUnit = "junit:junit:${DependencyVersions.jUnitVersion}"
        const val androidxExtjUnit = "androidx.test.ext:junit:${DependencyVersions.androidxJunit}"
        const val espresso =
            "androidx.test.espresso:espresso-core:${DependencyVersions.androidxEspresso}"
        const val composejUnit =
            "androidx.compose.ui:ui-test-junit4:${DependencyVersions.composeVersion}"
        const val mockk: String = "io.mockk:mockk:${DependencyVersions.mockk}"
        const val coroutineAndroid =
            "org.jetbrains.kotlinx:kotlinx-coroutines-android:${DependencyVersions.coroutine}"
        const val coroutineTest =
            "org.jetbrains.kotlinx:kotlinx-coroutines-test:${DependencyVersions.coroutine}"
        const val hiltTests =
            "com.google.dagger:hilt-android-testing:${DependencyVersions.daggerHilt}"
    }

    object Network {
        const val okHttpLoggingInterceptor =
            "com.squareup.okhttp3:logging-interceptor:${DependencyVersions.okHttpVersion}"
        const val retrofit = "com.squareup.retrofit2:retrofit:${DependencyVersions.retrofit}"
        const val retrofitMoshiConverter =
            "com.squareup.retrofit2:converter-moshi:${DependencyVersions.retrofitMoshiConverter}"
    }

    object Log {
        const val timber = "com.jakewharton.timber:timber:${DependencyVersions.timber}"
    }

    object AsyncImages {
        const val coil = "io.coil-kt:coil-compose:${DependencyVersions.coil}"
    }
}

object ModulePlugins {
    const val androidApplication = "com.android.application"
    const val kotlinAndroid = "kotlin-android"
    const val kotlinAndroidExtensions = "kotlin-android-extensions"
    const val kotlinKapt = "kotlin-kapt"
    const val daggerHilt = "dagger.hilt.android.plugin"
}

object GradlePlugins {
    const val buildGradle = "com.android.tools.build:gradle:${DependencyVersions.buildGradle}"
    const val kotlinGradlePlugin =
        "org.jetbrains.kotlin:kotlin-gradle-plugin:${DependencyVersions.kotlinGradlePlugin}"
    const val hiltGradlePlugin =
        "com.google.dagger:hilt-android-gradle-plugin:${DependencyVersions.daggerHilt}"
}
