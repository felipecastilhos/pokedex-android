object Versions {
    const val androidxCore = "1.7.0"
    const val composeVersion = "1.0.5"
    const val androidxLifecycle = "2.4.0"
    const val androidxAppCompat = "1.3.1"
    const val androidMaterial = "1.4.0"
    const val activityCompose = "1.4.0"
    const val jUnitVersion = "4.13.2"
    const val androidxJunit = "1.1.3"
    const val androidxEspresso = "3.4.0"
    const val androidxComposeJunit = "1.0.5"
}

object Dependencies {
    object Core {
        const val androidxCore = "androidx.core:core-ktx:${Versions.androidxCore}"
    }

    object Compose {
        const val ui = "androidx.compose.ui:ui:${Versions.composeVersion}"
        const val material = "androidx.compose.material:material:${Versions.composeVersion}"
        const val uiTooling = "androidx.compose.ui:ui-tooling-preview:${Versions.composeVersion}"
    }

    object AndroidLifecycle {
        const val viewModelCompose = "androidx.lifecycle:lifecycle-viewmodel-compose:${Versions.androidxLifecycle}"
        const val runtimeKtx = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.androidxLifecycle}"
    }

    object Ui {
        const val appCompat = "androidx.appcompat:appcompat:${Versions.androidxAppCompat}"
        const val material = "com.google.android.material:material:${Versions.androidMaterial}"
        const val activityCompose = "androidx.activity:activity-compose:${Versions.activityCompose}"
    }

    object UnitTests {
        const val jUnit = "junit:junit:${Versions.jUnitVersion}"
        const val androidxExtjUnit = "androidx.test.ext:junit:${Versions.androidxJunit}"
        const val espresso = "androidx.test.espresso:espresso-core:${Versions.androidxEspresso}"
        const val composejUnit = "androidx.compose.ui:ui-test-junit4:${Versions.androidxComposeJunit}}"
    }

    object DebugTooling {
        const val composeUiTooling = "androidx.compose.ui:ui-test-junit4:1.0.5"
    }
}
