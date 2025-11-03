import net.fabricmc.loom.api.LoomGradleExtensionAPI
import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version("2.2.21")
    id("dev.architectury.loom") version "1.11-SNAPSHOT" apply false
    id("architectury-plugin") version "3.4-SNAPSHOT"
    id("com.gradleup.shadow") version "8.3.6" apply false
}

val minecraftVersion : String by project

architectury {
    minecraft = minecraftVersion
}

val modName : String by project
val modId : String by project
val modGroupId : String by project
val modVersion : String by project

val neoVersion : String by project
allprojects {
    group = modGroupId
    version = modVersion
}

subprojects {
    apply { plugin("dev.architectury.loom") }
    apply { plugin("architectury-plugin") }

    repositories{
        maven {
            name = "NeoForged"
            url = uri("https://maven.neoforged.net/releases")
        }
    }

    val loomProperty : LoomGradleExtensionAPI = the<LoomGradleExtensionAPI>()

    fun Project.loom(configure: Action<LoomGradleExtensionAPI>): Unit =
        (this as ExtensionAware).extensions.configure("loom", configure)

    loom {
        silentMojangMappingsLicense()
    }
    base {
        archivesName = "$modName-${project.name}"
    }

    dependencies {
        "minecraft"("net.minecraft:minecraft:$minecraftVersion")
        "mappings"(loomProperty.officialMojangMappings())
    }

    java {
        withSourcesJar()

        sourceCompatibility = JavaVersion.VERSION_21
        targetCompatibility = JavaVersion.VERSION_21
    }

    tasks.withType<KotlinCompile>().configureEach {
        compilerOptions {
            jvmTarget = JvmTarget.JVM_21
        }
    }

}
