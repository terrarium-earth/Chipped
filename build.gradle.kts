import earth.terrarium.cloche.api.metadata.CommonMetadata
import groovy.json.StringEscapeUtils

plugins {
    java
    `maven-publish`
    id("com.teamresourceful.resourcefulgradle") version "0.0.+"
    id("earth.terrarium.cloche") version "0.18.14"
}

base {
    archivesName.set("chipped-26.1.2")
}

repositories {
    mavenCentral()

    cloche {
        main()
        mavenNeoforged()
        mavenNeoforgedMeta()
        mavenFabric()
    }

    maven(url = "https://maven.teamresourceful.com/repository/maven-public/")
    maven(url = "https://maven.firstdarkdev.xyz/snapshots")
    maven(url = "https://maven.shedaniel.me")

    maven {
        url = uri("https://www.cursemaven.com")
        content {
            includeGroup("curse.maven")
        }
    }

    exclusiveContent {
        forRepository {
            maven {
                name = "Modrinth"
                url = uri("https://api.modrinth.com/maven")
            }
        }
        filter {
            includeGroup("maven.modrinth")
        }
    }
}

cloche {
    val emiVersion = "0.5.0"
    minecraftVersion = "26.1.2"

    metadata {
        modId = "chipped"
        name = "Chipped"
        description = "A new friend for every block!"
        author("CodexAdrian", "adrian@terrarium.earth")
        author("ThatGravyBoat", "sophie@terrarium.earth")

        contributor("Facu")
        contributor("King")
        contributor("Shrimp")
        contributor("Jooosh")

        require("athena", "4.7.3")
        require("resourcefullib", "4.0.0")
        require("resourcefulconfig", "4.0.0")
    }

    common {

    }

    neoforge {
        loaderVersion = "26.1.2.76"

        data()

        dependencies {
            legacyClasspath("com.teamresourceful:yabn:1.0.3")
            legacyClasspath("com.teamresourceful:bytecodecs:1.0.2")
        }
    }

    fabric {
        loaderVersion = "0.19.3"
        includedClient()

        metadata {
            dependency {
                modId = "fabric-api"
                type = CommonMetadata.Dependency.Type.Required
            }
        }

        dependencies {
            fabricApi("0.151.0")
        }
    }

    targets.all {
        datagenDirectory = file("src/main/generated/resources")
        dependencies {
            modApi(
                module(
                    group = "com.teamresourceful.resourcefullib",
                    name = "resourcefullib-$loaderName-26.1",
                    version = "4.0.1"
                )
            )
            modApi(
                module(
                    group = "com.teamresourceful.resourcefulconfig",
                    name = "resourcefulconfig-$loaderName-26.1",
                    version = "4.0.1"
                )
            )
            modLocalRuntime(
                module(
                    group = "earth.terrarium.athena",
                    name = "athena-$loaderName-26.1",
                    version = "4.7.3"
                )
            )
        }
    }
}