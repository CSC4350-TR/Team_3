
buildscript {
    repositories {
        // Make sure that you have the following two repositories
        google()  // Google's Maven repository
        mavenCentral()  // Maven Central repository
    }
    dependencies {
        classpath("com.android.tools.build:gradle:7.3.1")
        classpath ("com.google.gms:google-services:4.3.13")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.5.20")
    }
}
plugins {
    //trick: for the same plugin versions in all sub-modules
    id("com.android.application").version("7.2.0").apply(false)
    id("com.android.library").version("7.2.0").apply(false)
    kotlin("android").version("1.7.10").apply(false)
    kotlin("multiplatform").version("1.7.10").apply(false)
    kotlin("plugin.serialization").version("1.6.10")
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
