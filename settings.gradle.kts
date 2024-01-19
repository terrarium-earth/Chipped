enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

rootProject.name = "chipped"

pluginManagement {
    repositories {
        maven(url = "https://maven.architectury.dev/")
        maven(url = "https://maven.minecraftforge.net/")
        maven(url = "https://maven.teamresourceful.com/repository/maven-public/")
        gradlePluginPortal()
    }
}

include("common")
include("fabric")
include("forge")
