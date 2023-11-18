plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    kotlin("kapt")
    id ("com.squareup.anvil")
}

android {
    namespace = "com.deividasstr.di"
    compileSdk = 34

    defaultConfig {
        minSdk = 34
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
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    kapt {
        generateStubs = true
        correctErrorTypes = true
    }
}

dependencies {
    api("androidx.lifecycle:lifecycle-viewmodel-ktx:2.7.0-rc01")
    api("androidx.lifecycle:lifecycle-viewmodel-savedstate:2.7.0-rc01")
    api("androidx.fragment:fragment-ktx:1.6.2")
    api("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.3")
    api("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.3")

    api ("com.google.dagger:dagger:2.48.1")
    kapt ("com.google.dagger:dagger-compiler:2.48.1")
    api ("com.google.dagger:dagger-android-support:2.48.1")
    kapt ("com.google.dagger:dagger-android-processor:2.48.1")
    api ("javax.inject:javax.inject:1")
}