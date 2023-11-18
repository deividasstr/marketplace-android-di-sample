plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id ("com.squareup.anvil")
    kotlin("kapt")
}

android {
    namespace = "com.deividasstr.newhost"
    compileSdk = 34

    defaultConfig {
        minSdk = 34

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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

    kapt {
        correctErrorTypes = true
        generateStubs = true
    }
}

dependencies {
    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.10.0")
    implementation(project(":base"))
    implementation(project(":plugin"))
    implementation(project(":paymentplugin"))
    kapt ("com.google.dagger:dagger-compiler:2.48.1")
    kapt ("com.google.dagger:dagger-android-processor:2.48.1")
}