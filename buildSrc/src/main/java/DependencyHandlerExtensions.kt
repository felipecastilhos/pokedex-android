import org.gradle.kotlin.dsl.DependencyHandlerScope

/**
 * Add AndroidX dependencies
 */
fun DependencyHandlerScope.jetpackCoreLibraries() {
    implementation(Dependencies.JetpackCompose.androidxCore)
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
    implementation(Dependencies.JetpackCompose.navigationCompose)
    implementation(Dependencies.JetpackCompose.hiltNavigationCompose)
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
    kaptAndroidTest(Dependencies.DependencyInjection.daggerHiltCompiler)
    kapt(Dependencies.DependencyInjection.jetpackHiltCompiler)
    testImplementation(Dependencies.Tests.coroutineTest)
}

fun DependencyHandlerScope.retrofitLibraries() {
    implementation(Dependencies.Network.retrofit)
    implementation(Dependencies.Network.retrofitMoshiConverter)
}

fun DependencyHandlerScope.okHttpLibraries() {
    api(Dependencies.Network.okHttpLoggingInterceptor)
    implementation("com.squareup.okhttp3:logging-interceptor:4.9.2")
}

/**
 * Add log dependencies.
 */
fun DependencyHandlerScope.logLibraries() {
    implementation(Dependencies.Log.timber)
}

fun DependencyHandlerScope.asyncImageLibraries() {
    implementation(Dependencies.AsyncImages.coil)
}

/**
 * Add unit tests dependencies.
 */
fun DependencyHandlerScope.unitTestsLibraries() {
    testImplementation(Dependencies.Tests.jUnit)
    testImplementation(Dependencies.Tests.coroutineAndroid)

}

fun DependencyHandlerScope.mockLibraries() {
    testImplementation(Dependencies.Tests.mockk)
}

/**
 * Add unit tests dependencies.
 */
fun DependencyHandlerScope.instrumentationTestsLibraries() {
    androidTestImplementation(Dependencies.Tests.androidxExtjUnit)
    androidTestImplementation(Dependencies.Tests.espresso)
    androidTestImplementation(Dependencies.Tests.composejUnit)
    androidTestImplementation(Dependencies.Tests.hiltTests)
    androidTestImplementation(Dependencies.Tests.jUnit)
    kaptAndroidTest(Dependencies.DependencyInjection.jetpackHiltCompiler)

}

/**
 * Extension add library operator in Kotlin Gradle SDL
 */
fun DependencyHandlerScope.implementation(dependencyNotation: String) {
    "implementation"(dependencyNotation)
}

/**
 * Extension to share library operator in Kotlin Gradle SDL
 */
fun DependencyHandlerScope.api(dependencyNotation: String) {
    "api"(dependencyNotation)
}

/**
 * Extension to add library for instrumented tests only in Kotlin Gradle SDL
 */
fun DependencyHandlerScope.testImplementation(dependencyNotation: String) {
    "testImplementation"(dependencyNotation)
}

/**
 * Extension to add library for testing only in Kotlin Gradle SDL
 */
fun DependencyHandlerScope.androidTestImplementation(dependencyNotation: String) {
    "androidTestImplementation"(dependencyNotation)
}

/**
 * Extension to add library to the build in Kotlin Gradle SDL
 */
fun DependencyHandlerScope.kapt(dependencyNotation: String) {
    "kapt"(dependencyNotation)
}

/**
 * Extension to add library to the build in Kotlin Gradle SDL
 */
fun DependencyHandlerScope.kaptAndroidTest(dependencyNotation: String) {
    "kaptAndroidTest"(dependencyNotation)
}

/**
 * Extension to call debugImplementation operator in Kotlin Gradle SDL
 */
fun DependencyHandlerScope.debugImplementation(dependencyNotation: String) {
    "debugImplementation"(dependencyNotation)
}
