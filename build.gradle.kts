import com.teamresourceful.utils.Platform
import com.teamresourceful.utils.getPlatform

plugins {
    java
    id("maven-publish")
    alias(libs.plugins.resourceful.gradle)
    alias(libs.plugins.resourceful.minecraft) apply false
}

subprojects {
    apply(plugin = "maven-publish")

    val platform = getPlatform()

    when (platform) {
        Platform.COMMON -> {
            apply(plugin = "com.teamresourceful.plugins.minecraft-platform-common")
            sourceSets.main.get().resources.srcDir("src/main/generated/resources")
        }
        Platform.FABRIC -> apply(plugin = "com.teamresourceful.plugins.minecraft-platform-fabric")
        Platform.NEOFORGE -> apply(plugin = "com.teamresourceful.plugins.minecraft-platform-neoforge")
    }

    if (platform != Platform.COMMON) {
        tasks.withType<JavaCompile> {
            val serviceArgs = listOf(
                "-Xplugin:ServicePlugin",
                "--service-plugin-platform=$platform",
            )

            options.encoding = "UTF-8"
            options.compilerArgs.add(serviceArgs.joinToString(separator = " "))
        }
    }

    repositories {
        mavenLocal()
        maven("https://maven.blamejared.com/")
    }

    dependencies {
        if (platform != Platform.COMMON) {
            annotationProcessor(rootProject.libs.service.plugin)
        }

        implementation("com.teamresourceful.resourcefullib:resourcefullib-${platform.id}-26.1:${rootProject.libs.versions.resourceful.lib.get()}")
        implementation("earth.terrarium.athena:athena-${platform.id}-26.1:${rootProject.libs.versions.athena.get()}")

        compileOnly("mezz.jei:jei-${rootProject.libs.versions.minecraft.get()}-${platform.id}-api:${rootProject.libs.versions.jei.get()}")
        runtimeOnly("mezz.jei:jei-${rootProject.libs.versions.minecraft.get()}-${platform.id}:${rootProject.libs.versions.jei.get()}")
    }
}