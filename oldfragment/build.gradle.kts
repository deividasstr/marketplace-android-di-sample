plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    kotlin("kapt")
    id ("com.squareup.anvil")
}

android {
    namespace = "com.deividasstr.oldfragment"
    compileSdk = 34

    defaultConfig {
        minSdk = 34

        consumerProguardFiles("consumer-rules.pro")
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
}

dependencies {
    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.10.0")
    implementation(project(":base"))
    kapt ("com.google.dagger:dagger-compiler:2.48.1")
    kapt ("com.google.dagger:dagger-android-processor:2.48.1")
}