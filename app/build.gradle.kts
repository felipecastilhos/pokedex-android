plugins {
    id(DependencyPlugins.androidApplication)
    id(DependencyPlugins.kotlinAndroid)
    id(DependencyPlugins.kotlinAndroidExtensions)
    id(DependencyPlugins.kotlinKapt)
    id(DependencyPlugins.daggerHilt)
}

android {
    compileSdk = BuildConfigVersions.compileSdk

    defaultConfig {
        applicationId = "com.github.felipecastilhos.pokedexandroid"
        minSdk = BuildConfigVersions.minSdk
        targetSdk = BuildConfigVersions.targetSdk
        versionCode = BuildConfigVersions.versionCode
        versionName = BuildConfigVersions.versionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        defaultConfig {
            vectorDrawables.useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        viewBinding = true
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = DependencyVersions.kotlinCompilerExtension
    }

    packagingOptions {
        resources.excludes += "META-INF/licenses/**"
        resources.excludes += "META-INF/AL2.0"
        resources.excludes += "META-INF/LGPL2.1"
    }
}

dependencies {
    implementation(Dependencies.Core.androidxCore)
    implementation(Dependencies.Ui.appCompat)
    implementation(Dependencies.Ui.material)
    implementation(Dependencies.Ui.activityCompose)
    implementation(Dependencies.Compose.ui)
    implementation(Dependencies.Compose.material)
    implementation(Dependencies.Compose.uiToolingPreview)
    implementation(Dependencies.AndroidLifecycle.viewModelCompose)
    implementation(Dependencies.AndroidLifecycle.runtimeKtx)
    implementation(Dependencies.AndroidLifecycle.runtimeKtx)
    implementation(Dependencies.DependencyInjection.daggerHilt)
    kapt(Dependencies.DependencyInjection.daggerHiltCompiler)
    testImplementation(Dependencies.Tests.jUnit)
    androidTestImplementation(Dependencies.Tests.androidxExtjUnit)
    androidTestImplementation(Dependencies.Tests.espresso)
    androidTestImplementation(Dependencies.Tests.composejUnit)
    debugImplementation(Dependencies.Compose.composeUiTooling)
}
