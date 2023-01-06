plugins {
    id(ModulePlugins.androidApplication)
    id(ModulePlugins.kotlinAndroid)
    id(ModulePlugins.kotlinAndroidExtensions)
    id(ModulePlugins.kotlinKapt)
    id(ModulePlugins.daggerHilt)
}

android {
    compileSdk = BuildConfigVersions.compileSdk
    namespace="com.github.felipecastilhos.pokedexandroid"
    defaultConfig {
        applicationId = "com.github.felipecastilhos.pokedexandroid"
        minSdk = BuildConfigVersions
            .minSdk
        targetSdk = BuildConfigVersions.targetSdk
        versionCode = BuildConfigVersions.versionCode
        versionName = BuildConfigVersions.versionName

        testInstrumentationRunner = "com.github.felipecastilhos.pokedexandroid.CustomTestRunner"

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
    testImplementation("androidx.test.ext:junit-ktx:1.1.3")

    // Common libraries
    jetpackCoreLibraries()
    jetpackKotlinExtensionsLibraries()
    jetpackAndroidLifecycleLibraries()

    // UI Libraries
    jetpackUiCommonsLibraries()
    jetpackComposeLibraries()

    // Add dependency injection dependencies
    hiltLibraries()

    // Add networking libraries
    okHttpLibraries()
    retrofitLibraries()

    // Add log libraries
    logLibraries()

    // Add async image libraries
    asyncImageLibraries()

    // Add Tests
    unitTestsLibraries()
    instrumentationTestsLibraries()
    mockLibraries()
}

kapt {
    correctErrorTypes = true
}