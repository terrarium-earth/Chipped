plugins {
    java
}

neoForge {
    runs {
        create("clientData") {
            clientData()
            ideName = "Minecraft Client Data - NeoForge"

            programArguments.addAll(
                "--all",
                "--mod", "chipped",
                "--output", file("../common/src/main/generated/resources2").absolutePath,
                "--existing", file("../common/src/main/resources").absolutePath
            )
        }
    }
}