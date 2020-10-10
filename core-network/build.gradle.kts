plugins {
    id("com.android.library")
    id("kotlin-android")
    id("kotlin-android-extensions")
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
    implementation(project (":model"))
    implementation(Dependencies.Network.OkHttp.core)
    implementation(Dependencies.Network.OkHttp.logger)

    implementation(Dependencies.Network.Retrofit.core)
    implementation(Dependencies.Network.Retrofit.coroutines)
    implementation(Dependencies.Network.Retrofit.gson)
}