# Chipped

To add this library to your project, do the following:

Kotlin DSL:
```kotlin
repositories {
    maven(url = "https://maven.teamresourceful.com/repository/maven-public/")
}

dependencies {
    "modImplementation"(group = "earth.terrarium.chipped", name = "chipped-$modLoader-$minecraftVersion", version = chippedVersion)
}
```

Groovy DSL:
```groovy
repositories {
    maven {
        url "https://maven.teamresourceful.com/repository/maven-public/"
    }
}

dependencies {
    "modImplementation" group: "earth.terrarium.chipped", name: "chipped-$modLoader-$minecraftVersion", version: chippedVersion
}
```
