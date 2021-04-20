
[![Tag Badge](https://badgen.net/github/tag/tgloureiro/android-bloc)](https://badgen.net/github/tag/tgloureiro/android-bloc)
[![License Badge](https://badgen.net/github/license/tgloureiro/android-bloc)](https://badgen.net/github/license/tgloureiro/android-bloc)

# Android-BLoC

State management library to implement the BLoC design pattern on Android. 

This package is inspired by the concept of BLoC proposed by Paolo Soares on DartConf 2018 and by Felix Angelov's Flutter Bloc State Management Library.

# Installation

- 1. Add the JitPack repository to your build file. 
Add it in your root build.gradle at the end of repositories:

```
allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```
- 2. Add the dependency on the app's build.gradle. Set $lib_version_tag with the latest tag version, ex.:('0.1.2').
[![Tag Badge](https://badgen.net/github/tag/tgloureiro/android-bloc)](https://badgen.net/github/tag/tgloureiro/android-bloc)
```
dependencies {
	        implementation 'com.github.tgloureiro:android-bloc:$lib_version_tag'
	}
```


# How BLoC works as a design pattern:

<img src="/docs/assets/main_concept.svg" alt="Main Concept" width="200"/>

## A view can connect to multiple BloCs

<img src="/docs/assets/view_to_multiple_blocs.svg" alt="View connected to multiple BloCs" width="200"/>

## A BLoC can connect to multiple BloCs

<img src="/docs/assets/bloc_to_multiple_blocs.svg" alt="Bloc connected to multiple BloCs" width="200"/>

# How Android BLoC works:

<img src="/docs/assets/android_bloc.svg" alt="Usage in Android" width="400"/>

## Using Android's ViewModel as a BLoC provider

<img src="/docs/assets/view_model_as_bloc_provider.svg" alt="ViewModel as BLoC Provider" width="400"/>
