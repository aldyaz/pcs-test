include(":common")

pluginManagement {

    includeBuild("build-logic")

    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
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

rootProject.name = "PCS Test"

include(":app")
include(":datasource")
include(
    ":member:data",
    ":member:domain",
    ":member:presentation",
    ":member:ui"
)
include(
    ":common:data",
    ":common:domain",
    ":common:presentation",
    ":common:ui"
)
