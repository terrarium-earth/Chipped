architectury {
    val enabledPlatforms: String by rootProject
    common(enabledPlatforms.split(","))
}

dependencies {
    val fabricLoaderVersion: String by project

    modImplementation(group = "net.fabricmc", name = "fabric-loader", version = fabricLoaderVersion)
    modCompileOnly(group = "tech.thatgravyboat", name = "commonats", version = "1.0")
}
