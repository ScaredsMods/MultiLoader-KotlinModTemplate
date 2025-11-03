plugins {
    kotlin("jvm") version ("2.2.21")
}

architectury {
    val enabledPlatforms : String by rootProject
    common {
       enabledPlatforms.split(',')
    }
}

dependencies {
    // We depend on Fabric Loader here to use the Fabric @Environment annotations,
    // which get remapped to the correct annotations on each platform.
    // Do NOT use other classes from Fabric Loader.
    modImplementation("net.fabricmc:fabric-loader:${rootProject.extra["fabricLoaderVersion"]}")
}

