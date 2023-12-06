plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id ("com.squareup.anvil")
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
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }

    anvil {
        generateDaggerFactories = true
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
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.10.0")
    implementation(project(":base"))
    implementation(project(":plugin"))
}