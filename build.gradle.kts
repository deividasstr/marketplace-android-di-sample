
// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application") version "8.2.0-rc03" apply false
    id("org.jetbrains.kotlin.android") version "1.9.20" apply false
    id("scabbard.gradle") version "0.5.0"
    id("com.android.library") version "8.2.0-rc03" apply false
    id("com.squareup.anvil") version "2.4.8" apply false
}

scabbard {
    failOnError = true
    enabled = true
    outputFormat = "svg"
    fullBindingGraphValidation = false
}

allprojects {
    configurations.all {
        resolutionStrategy.eachDependency {
            if (requested.group == "com.github.kittinunf.result" && requested.name == "result" && requested.version == "3.0.0") {
                useVersion("3.0.1")
                because("Transitive dependency of Scabbard, currently not available on mavenCentral()")
            }
        }
    }
}

