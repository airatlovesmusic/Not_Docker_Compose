buildscript {
    val kotlin_version by extra("1.4.10")
    repositories {
        gradlePluginPortal()
        jcenter()
        google()
        mavenCentral()
    }
    dependencies {
        classpath("com.android.tools.build:gradle:4.2.0-alpha13")
        classpath("org.jetbrains.kotlin:kotlin-serialization:$kotlin_version")
        classpath(kotlin("gradle-plugin", kotlin_version))
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