# pokedex-android
# About Android Pokedex project
Hello there ,
In this project I tried showcasing how to build an Android Application with clean architecture and MVI using some of the jetpack libraries with Kotlin Coroutines & Dagger Hilt. This App is using the [GraphQL-Pokemon](https://github.com/favware/graphql-pokemon) as a remote data source.

This app is based on the [Guide to app architecture](https://developer.android.com/jetpack/docs/guide) article, [Kotlin 1.4](https://kotlinlang.org/docs/reference/whatsnew13.html), and [coroutine](https://kotlinlang.org/docs/reference/coroutines/basics.html). I also used some android architecture components like [LiveData](https://developer.android.com/jetpack/arch/livedata), [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel).

Libraries Used
---------------
* [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel) - store and manage UI-related data in a lifecycle conscious way
* [LiveData](https://developer.android.com/jetpack/arch/livedata) - notify the view when data changes .
* [Compose](https://developer.android.com/jetpack/compose) - describe ui components with declarative functions
* [Material](https://material.io/develop/android/docs/getting-started/) - Material Components.
* [Coroutine](https://github.com/Kotlin/kotlinx.coroutines#user-content-android) - performs background tasks
* [Flows](https://kotlin.github.io/kotlinx.coroutines/kotlinx-coroutines-core/kotlinx.coroutines.flow/-flow/) - for asynchronous data streams
* [Coil](https://github.com/coil-kt/coil) - An image loading library for Android backed by Kotlin Coroutines
* [Gson](https://github.com/google/gson) - JSON Parser
* [Apollo](https://www.apollographql.com/docs/android/)- GraphQL client for the JVM, Android and Kotlin multiplatform
* [Dagger Hilt](https://dagger.dev/hilt/) - dependency injector
* [Room](https://developer.android.com/training/data-storage/room) - Save data in a local database
* [Espresso](https://developer.android.com/training/testing/espresso/) // UI test
* [Junit](https://junit.org/junit4/) // unit tests
* [Truth](https://github.com/google/truth) // Makes your test assertions and failure messages more readable
