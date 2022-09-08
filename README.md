<div align="center">

<img height="200" src="images/project_logo.jpg" alt="Project logo"/>

# Pokédex Android

**An android application architecture exploration in compose**

If this project helps you in anyway, show your love :heart: by putting a :star: on this project

![Project License](https://img.shields.io/github/license/felipecastilhos/pokedex-android)
![WCAG WAI](https://img.shields.io/badge/WCAG_WAI-A-orange)
![Code Style](https://img.shields.io/badge/code%20style-%E2%9D%A4-FF4081.svg)
![Android Supported API](https://img.shields.io/badge/API-23%2B-green.svg?style=flat)
  
</div>

## About Android Pokedex project
Hello there,
In this project I tried showcasing how to build an Android Application in Jetpack Compose with clean architecture and MVI using some of the jetpack libraries with Kotlin Coroutines & Dagger Hilt. This App is using the [PokeApi](https://github.com/favware/graphql-pokemon) as a remote data source.

This app is based on the [Guide to app architecture](https://developer.android.com/jetpack/docs/guide) article, [Kotlin 1.5](https://kotlinlang.org/docs/reference/whatsnew13.html), and [coroutine](https://kotlinlang.org/docs/reference/coroutines/basics.html). I also used some android architecture components like [LiveData](https://developer.android.com/jetpack/arch/livedata), [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel).

You can check my short term backlog in my Github Projects [here](https://github.com/felipecastilhos/pokedex-android/projects/1)

## Project structure
```
project
    | buildSrc //Project gradle dependencies configurations - Ex.: versions and libs - and gradle dsl extensions
        | datasource //Feature remote and local data source
        | di //feature independency injection modules
        | domain //feature business classes
            | repository //data access abstractions
            | usecase //Business rules abstractions
            | viewmodel //state of the ui data
    | app //Main application module
        | features //project features
        | core //architecture and utility classes
            | coroutines //abstraction classes, helper classes and extensions to work with coroutines
            | datasource //abstraction classes, helper classes and extensions to work with datasources
            | di //architectural dependency injection modules and utility classes
            | logs //helper classes and extensions to work with logs
```


Libraries Used
---------------
* [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel) - store and manage UI-related data in a lifecycle conscious way
* [LiveData](https://developer.android.com/jetpack/arch/livedata) - notify the view when data changes .
* [Jetpack Compose](https://developer.android.com/jetpack/compose) - describe ui components with declarative functions
* [Material](https://material.io/develop/android/docs/getting-started/) - Material Components.
* [Coroutine](https://github.com/Kotlin/kotlinx.coroutines#user-content-android) - performs background tasks
* [Flows](https://kotlin.github.io/kotlinx.coroutines/kotlinx-coroutines-core/kotlinx.coroutines.flow/-flow/) - for asynchronous data streams
* [Coil](https://github.com/coil-kt/coil) - An image loading library for Android backed by Kotlin Coroutines
* [Moshi](https://github.com/square/moshi) - Moshi is a modern JSON library for Android, Java and Kotlin. It makes it easy to parse JSON into Java and Kotlin classes
* [Retrofit](https://square.github.io/retrofit/)- A type-safe HTTP client for Android and Java
* [OkHttp](https://square.github.io/okhttp/) - A network application
* [Dagger Hilt](https://dagger.dev/hilt/) - dependency injector
* [Room](https://developer.android.com/training/data-storage/room) - Save data in a local database
* [Espresso](https://developer.android.com/training/testing/espresso/) - UI test
* [Junit](https://junit.org/junit4/) - unit tests
* [Truth](https://github.com/google/truth) - Makes your test assertions and failure messages more readable
* [Mockk](https://mockk.io/) - Mocking library for kotlin
* [Detekt](https://github.com/detekt/detekt) - a static code analysis tool for the Kotlin programming language
* [KTLint](https://github.com/pinterest/ktlint) - Kotlin linter in spirit of feross/standard (JavaScript) and gofmt (Go).
* [Gradle Kotlin Plugin](https://kotlinlang.org/docs/gradle.html) - Gradle scripts in Kotlin
* [Timber](https://github.com/JakeWharton/timber) - Small log library based on Android SDK log