import org.gradle.kotlin.dsl.DependencyHandlerScope

/**
 * Add AndroidX dependencies
 */
fun DependencyHandlerScope.jetpackUtilLibraries() {
    implementation(Dependencies.Core.androidxCore)
}

/**
 * Add AndroidX dependencies
 */
fun DependencyHandlerScope.jetpackKotlinExtensionsLibraries() {
    implementation("androidx.core:core-ktx:${DependencyVersions.androidxCore}")
}

/**
 * Add JapackUi dependencies
 */
fun DependencyHandlerScope.jetpackUiCommonsLibraries() {
    implementation(Dependencies.JetpackUi.appCompat)
    implementation(Dependencies.JetpackUi.material)
}

/**
 * Add Japackcompose dependencies
 */
fun DependencyHandlerScope.jetpackComposeLibraries() {
    implementation(Dependencies.JetpackCompose.ui)
    implementation(Dependencies.JetpackCompose.material)
    implementation(Dependencies.JetpackCompose.uiToolingPreview)
    implementation(Dependencies.JetpackCompose.activityCompose)
    implementation(Dependencies.AndroidLifecycle.viewModelCompose)
    debugImplementation(Dependencies.JetpackCompose.composeUiTooling)
}

/**
 * Add Jetpack Compose Android lifecycle dependencies to handle better lifecycle changes
 */
fun DependencyHandlerScope.jetpackAndroidLifecycleLibraries() {
    implementation(Dependencies.AndroidLifecycle.runtimeKtx)
    implementation(Dependencies.AndroidLifecycle.viewModelCompose)
}

/**
 * Add hilt dependencies for dependency injection
 */
fun DependencyHandlerScope.hiltLibraries() {
    implementation(Dependencies.DependencyInjection.daggerHilt)
    kapt(Dependencies.DependencyInjection.daggerHiltCompiler)
    implementation(Dependencies.DependencyInjection.jetpackHiltLifecycleViewModel)
    kapt(Dependencies.DependencyInjection.jetpackHiltCompiler)
}

/**
 * Add Apollo Android client dependencies to manage both local and remote data with GraphQL.
 */
fun DependencyHandlerScope.apolloClientLibraries() {
    implementation(Dependencies.Network.apolloRuntime)
    implementation(Dependencies.Network.apolloCoroutines)
}

fun DependencyHandlerScope.okHttpLibraries() {
    implementation(Dependencies.Network.okHttpLoggingInterceptor)
    implementation("com.squareup.okhttp3:logging-interceptor:4.9.2")
}

/**
 * Add log dependencies.
 */
fun DependencyHandlerScope.logLibraries() {
    implementation(Dependencies.Log.timber)
}

/**
 * Add unit tests dependencies.
 */
fun DependencyHandlerScope.unitTestsLibraries() {
    testImplementation(Dependencies.Tests.jUnit)
}

/**
 * Add unit tests dependencies.
 */
fun DependencyHandlerScope.instrumentationTestsLibraries() {
    androidTestImplementation(Dependencies.Tests.androidxExtjUnit)
    androidTestImplementation(Dependencies.Tests.espresso)
    androidTestImplementation(Dependencies.Tests.composejUnit)
}

fun DependencyHandlerScope.implementation(dependencyNotation: String) {
    "implementation"(dependencyNotation)
}

fun DependencyHandlerScope.testImplementation(dependencyNotation: String) {
    "testImplementation"(dependencyNotation)
}

fun DependencyHandlerScope.androidTestImplementation(dependencyNotation: String) {
    "androidTestImplementation"(dependencyNotation)
}

fun DependencyHandlerScope.kapt(dependencyNotation: String) {
    "kapt"(dependencyNotation)
}

fun DependencyHandlerScope.debugImplementation(dependencyNotation: String) {
    "debugImplementation"(dependencyNotation)
}
