
plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    kotlin("kapt")
    id ("com.squareup.anvil")
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
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

// https://github.com/square/anvil/issues/693#issuecomment-1744013947
tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>().configureEach {
    // Kapt tasks are also KotlinCompile tasks, but we don't care about them
    if (this !is org.jetbrains.kotlin.gradle.tasks.KaptGenerateStubs) {
        val anvilSrcGenDir = layout.buildDirectory.dir(sourceSetName.map{ "anvil/src-gen-$it/anvil" })
        // adds the Anvil directory to the task's outputs
        this.outputs.dir(anvilSrcGenDir)
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
    kapt ("com.google.dagger:dagger-compiler:2.48.1")
    kapt ("com.google.dagger:dagger-android-processor:2.48.1")
}