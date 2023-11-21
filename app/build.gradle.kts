
plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    kotlin("kapt")
    id("com.google.dagger.hilt.android")
}

android {
    namespace = "com.deividasstr.app"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.deividasstr.vinted_di"
        minSdk = 34
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        vectorDrawables {
            useSupportLibrary = true
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        viewBinding = true
    }
    kapt {
        correctErrorTypes = true
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    implementation("androidx.core:core-ktx:1.12.0")
    implementation(project(":base"))
    implementation(project(":newfragment"))
    implementation(project(":oldfragment"))
    implementation(project(":newhost"))
    implementation(project(":oldhost"))
    implementation(project(":plugin"))
    implementation(project(":paymentplugin"))
    implementation("com.google.dagger:hilt-android:2.48.1")

    kapt("com.google.dagger:hilt-android-compiler:2.48.1")
}