object DependencyVersions {
    const val androidxCore = "1.7.0"
    const val androidxAppCompat = "1.3.1"

    const val composeVersion = "1.0.5"
    const val androidxLifecycle = "2.4.0"
    const val androidMaterial = "1.4.0"
    const val activityCompose = "1.4.0"
    const val jUnitVersion = "4.13.2"
    const val androidxJunit = "1.1.3"
    const val androidxEspresso = "3.4.0"
    const val androidxComposeJunit = "1.0.5"
    const val kotlinCompilerExtension = "1.0.1"
    const val daggerHilt = "2.37"

    const val buildGradle = "7.0.3"
    const val kotlinGradlePlugin = "1.5.21"
}

sealed class Dependencies {
    object Core {
        const val androidxCore = "androidx.core:core-ktx:${DependencyVersions.androidxCore}"
    }

    object DependencyInjection {
        const val daggerHilt = "com.google.dagger:hilt-android:${DependencyVersions.daggerHilt}"
        const val daggerHiltCompiler = "com.google.dagger:hilt-android-compiler:${DependencyVersions.daggerHilt}"
    }

    object Compose {
        const val ui = "androidx.compose.ui:ui:${DependencyVersions.composeVersion}"
        const val material =
            "androidx.compose.material:material:${DependencyVersions.composeVersion}"
        const val uiToolingPreview =
            "androidx.compose.ui:ui-tooling-preview:${DependencyVersions.composeVersion}"
        const val composeUiTooling =
            "androidx.compose.ui:ui-tooling:${DependencyVersions.composeVersion}"
    }

    object AndroidLifecycle {
        const val viewModelCompose =
            "androidx.lifecycle:lifecycle-viewmodel-compose:${DependencyVersions.androidxLifecycle}"
        const val runtimeKtx =
            "androidx.lifecycle:lifecycle-runtime-ktx:${DependencyVersions.androidxLifecycle}"
    }

    object Ui {
        const val appCompat = "androidx.appcompat:appcompat:${DependencyVersions.androidxAppCompat}"
        const val material =
            "com.google.android.material:material:${DependencyVersions.androidMaterial}"
        const val activityCompose =
            "androidx.activity:activity-compose:${DependencyVersions.activityCompose}"
    }

    object Tests {
        const val jUnit = "junit:junit:${DependencyVersions.jUnitVersion}"
        const val androidxExtjUnit = "androidx.test.ext:junit:${DependencyVersions.androidxJunit}"
        const val espresso =
            "androidx.test.espresso:espresso-core:${DependencyVersions.androidxEspresso}"
        const val composejUnit =
            "androidx.compose.ui:ui-test-junit4:${DependencyVersions.androidxComposeJunit}"
    }
}

object DependencyPlugins {
    const val androidApplication = "com.android.application"
    const val kotlinAndroid = "kotlin-android"
    const val kotlinAndroidExtensions = "kotlin-android-extensions"
    const val kotlinKapt = "kotlin-kapt"
    const val daggerHilt = "dagger.hilt.android.plugin"
}

object ClassPathDependencies {
    const val buildGradle = "com.android.tools.build:gradle:${DependencyVersions.buildGradle}"
    const val kotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${DependencyVersions.kotlinGradlePlugin}"
    const val hiltGradlePlugin = "com.google.dagger:hilt-android-gradle-plugin:${DependencyVersions.daggerHilt}"
}
