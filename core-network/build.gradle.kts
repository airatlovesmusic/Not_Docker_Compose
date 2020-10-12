plugins {
    id("com.android.library")
    id("kotlin-android")
    id("kotlin-android-extensions")
    id("kotlinx-serialization")
}

android {
    compileSdkVersion(30)
    buildToolsVersion("29.0.3")

    defaultConfig {
        minSdkVersion(23)
        targetSdkVersion(30)
    }
}

dependencies {
    implementation(project(":model"))
    implementation(Dependencies.Ktor.android)
    implementation(Dependencies.Ktor.core)
    implementation(Dependencies.Ktor.serialization)
    implementation(Dependencies.Ktor.json)
    implementation(Dependencies.Serialization.core)
    implementation(Dependencies.Serialization.json)
}