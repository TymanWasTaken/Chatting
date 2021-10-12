import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("fabric-loom")
    id("com.ncorti.ktfmt.gradle")
    kotlin("jvm")
}

java.sourceCompatibility = JavaVersion.VERSION_16
java.targetCompatibility = JavaVersion.VERSION_16

val archives_base_name: String by project
val mod_version: String by project
val maven_group: String by project
val fabric_kotlin_version: String by project
val fabric_version: String by project
val loader_version: String by project
val yarn_mappings: String by project
val minecraft_version: String by project

base.archivesBaseName = archives_base_name
version = mod_version
group = maven_group

repositories {
    // Add repositories to retrieve artifacts from in here.
	// You should only use this when depending on other mods because
	// Loom adds the essential maven repositories to download Minecraft and libraries from automatically.
	// See https://docs.gradle.org/current/userguide/declaring_repositories.html
	// for more information about repositories.
    maven("https://repo.sk1er.club/repository/maven-public")
}

dependencies {
    //to change the versions see the gradle.properties file
    minecraft("com.mojang:minecraft:${minecraft_version}")
    mappings("net.fabricmc:yarn:${yarn_mappings}:v2")
    modImplementation("net.fabricmc:fabric-loader:${loader_version}")

    // Fabric API. This is technically optional, but you probably want it anyway.
    modImplementation("net.fabricmc.fabric-api:fabric-api:${fabric_version}")

    modImplementation("net.fabricmc:fabric-language-kotlin:${fabric_kotlin_version}")

    // PSA: Some older mods, compiled on Loom 0.2.1, might have outdated Maven POMs.
    // You may need to force-disable transitiveness on them.
    modImplementation("gg.essential:essential-1.17.1-fabric:1506") {
        exclude("net.fabricmc")
        isTransitive = false
    }
    modImplementation("gg.essential:vigilance-1.17.1-fabric:182") {
        exclude("net.fabricmc")
    }
    modImplementation("gg.essential:elementa-1.17.1-fabric:386") {
        exclude("net.fabricmc")
    }
    modImplementation("gg.essential:universalcraft-1.17.1-fabric:165") {
        exclude("net.fabricmc")
    }
    implementation(
        include("gg.essential:loader-fabric:1.0.0") {
            isTransitive = false
        }
    )
}

tasks.withType<ProcessResources> {
    filesMatching("fabric.mod.json") {
        expand(
            mutableMapOf(
                "version" to mod_version,
            )
        )
    }
}

// ensure that the encoding is set to UTF-8, no matter what the system default is
// this fixes some edge cases with special characters not displaying correctly
// see http://yodaconditions.net/blog/fix-for-java-file-encoding-problems-with-gradle.html
tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"

    // Minecraft 1.17 (21w19a) upwards uses Java 16.
    options.release.set(16)
}

java {
    // Loom will automatically attach sourcesJar to a RemapSourcesJar task and to the "build" task
    // if it is present.
    // If you remove this line, sources will not be generated.
    withSourcesJar()
}

tasks.withType<Jar> {
    from("LICENSE") {
        rename { "${it}_${archives_base_name}"}
    }
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "16"
}

ktfmt {
    kotlinLangStyle()
}