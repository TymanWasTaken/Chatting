pluginManagement {
    repositories {
        maven("https://maven.fabricmc.net/")
        maven("https://plugins.gradle.org/m2/")
        gradlePluginPortal()
    }
    val loom_version: String by settings
    val kotlin_version: String by settings
    val ktfmt_version: String by settings
    plugins {
        id("fabric-loom") version loom_version
        id("com.ncorti.ktfmt.gradle") version ktfmt_version
        kotlin("jvm") version kotlin_version
    }
}
