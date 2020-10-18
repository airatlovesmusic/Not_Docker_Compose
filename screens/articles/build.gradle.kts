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
    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerVersion = "1.4.0"
        kotlinCompilerExtensionVersion = "1.0.0-alpha04"
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
        useIR = true
    }
}

kotlin {
    sourceSets {
        all {
            languageSettings.apply {
                useExperimentalAnnotation("kotlin.ExperimentalStdlibApi")
                useExperimentalAnnotation("kotlinx.coroutines.ExperimentalCoroutinesApi")
                useExperimentalAnnotation("kotlinx.coroutines.FlowPreview")
                useExperimentalAnnotation("kotlinx.coroutines.InternalCoroutinesApi")
            }
        }
    }
}

dependencies {
    implementation(project(":commons:network"))
    implementation(project(":commons:global"))
    implementation(project(":commons:ui"))
    implementation(project(":model"))
    implementation(Dependencies.AndroidX.appcompat)
    implementation(Dependencies.AndroidX.coreKtx)
    implementation(Dependencies.AndroidX.activityKtx)

    implementation(Dependencies.AndroidX.Compose.core)
    implementation(Dependencies.AndroidX.Compose.foundation)
    implementation(Dependencies.AndroidX.Compose.layout)
    implementation(Dependencies.AndroidX.Compose.material)
    implementation(Dependencies.AndroidX.Compose.runtime)
    implementation(Dependencies.AndroidX.Compose.runtimeLivedata)
    implementation(Dependencies.AndroidX.Compose.tooling)

    implementation(Dependencies.AndroidX.Lifecycle.livedata)
    implementation(Dependencies.AndroidX.Lifecycle.viewmodel)
    implementation(Dependencies.AndroidX.Lifecycle.extensions)

    implementation(Dependencies.Koin.core)
    implementation(Dependencies.Koin.compose)
}