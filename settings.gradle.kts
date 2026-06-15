enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

rootProject.name = "Chipped"

pluginManagement {
    repositories {
        maven(url = "https://maven.teamresourceful.com/repository/maven-public/")
        maven(url = "https://maven.msrandom.net/repository/cloche")
        gradlePluginPortal()
    }
}