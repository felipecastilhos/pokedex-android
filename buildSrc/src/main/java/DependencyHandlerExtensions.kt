import org.gradle.kotlin.dsl.DependencyHandlerScope

/**
 * Add AndroidX dependencies
 */
fun DependencyHandlerScope.jetpackUtilLibraries() {
    "implementation"(Dependencies.Core.androidxCore)
}

/**
 * Add AndroidX dependencies
 */
fun DependencyHandlerScope.jetpackKotlinExtensionsLibraries() {
    "implementation"("androidx.core:core-ktx:${DependencyVersions.androidxCore}")
}

/**
 * Add JapackUi dependencies
 */
fun DependencyHandlerScope.jetpackUiCommonsLibraries() {
    "implementation"(Dependencies.JetpackUi.appCompat)
    "implementation"(Dependencies.JetpackUi.material)
}

/**
 * Add Japackcompose dependencies
 */
fun DependencyHandlerScope.jetpackComposeLibraries() {
    "implementation"(Dependencies.JetpackCompose.ui)
    "implementation"(Dependencies.JetpackCompose.material)
    "implementation"(Dependencies.JetpackCompose.uiToolingPreview)
    "implementation"(Dependencies.JetpackCompose.activityCompose)
    "implementation"(Dependencies.AndroidLifecycle.viewModelCompose)
    "debugImplementation"(Dependencies.JetpackCompose.composeUiTooling)
}

/**
 * Add Jetpack Compose Android lifecycle dependencies to handle better lifecycle changes
 */
fun DependencyHandlerScope.jetpackAndroidLifecycleLibraries() {
    "implementation"(Dependencies.AndroidLifecycle.runtimeKtx)
    "implementation"(Dependencies.AndroidLifecycle.viewModelCompose)
}

/**
 * Add Dagger-Hilt dependencies for dependency injection
 */
fun DependencyHandlerScope.daggerHiltLibraries() {
    "implementation"(Dependencies.DependencyInjection.daggerHilt)
    "kapt"(Dependencies.DependencyInjection.daggerHiltCompiler)
}

/**
 * Add unit tests dependencies.
 */
fun DependencyHandlerScope.unitTestsLibraries() {
    "testImplementation"(Dependencies.Tests.jUnit)
}

/**
 * Add unit tests dependencies.
 */
fun DependencyHandlerScope.instrumentationTestsLibraries() {
    "androidTestImplementation"(Dependencies.Tests.androidxExtjUnit)
    "androidTestImplementation"(Dependencies.Tests.espresso)
    "androidTestImplementation"(Dependencies.Tests.composejUnit)
}
