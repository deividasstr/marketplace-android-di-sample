pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "vinted-di"
include(":app")
include(":base")
include(":oldhost")
include(":plugin")
include(":paymentplugin")
include(":oldfragment")
include(":newfragment")
include(":newhost")
