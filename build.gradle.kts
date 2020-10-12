buildscript {
    repositories {
        gradlePluginPortal()
        jcenter()
        google()
        mavenCentral()
    }
    dependencies {
        classpath(Dependencies.androidGradlePlugin)
        classpath(Dependencies.Kotlin.gradlePlugin)
        classpath(Dependencies.Kotlin.serialization)
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
        jcenter()
    }
}

repositories {
    mavenCentral()
}