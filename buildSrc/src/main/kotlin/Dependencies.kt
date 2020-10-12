object Dependencies {
    const val androidGradlePlugin = "com.android.tools.build:gradle:4.2.0-alpha13"
    const val material = "com.google.android.material:material:1.1.0"

    object Serialization {
        private const val version = "1.0.0"
        const val core = "org.jetbrains.kotlinx:kotlinx-serialization-core:$version"
        const val json = "org.jetbrains.kotlinx:kotlinx-serialization-json:$version"
    }


    object Kotlin {
        private const val version = "1.4.10"
        const val stdlib = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:$version"
        const val gradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:$version"
        const val extensions = "org.jetbrains.kotlin:kotlin-android-extensions:$version"
        const val serialization = "org.jetbrains.kotlin:kotlin-serialization:$version"
    }

    object Coroutines {
        private const val version = "1.3.9"
        const val core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:$version"
        const val android = "org.jetbrains.kotlinx:kotlinx-coroutines-android:$version"
    }

    object AndroidX {
        const val appcompat = "androidx.appcompat:appcompat:1.2.0-rc01"
        const val coreKtx = "androidx.core:core-ktx:1.5.0-alpha01"
        const val activityKtx = "androidx.activity:activity-ktx:1.1.0"

        object Compose {
            const val version = "1.0.0-alpha04"
            const val core = "androidx.compose.ui:ui:$version"
            const val foundation = "androidx.compose.foundation:foundation:$version"
            const val layout = "androidx.compose.foundation:foundation-layout:$version"
            const val material = "androidx.compose.material:material:$version"
            const val materialIconsExtended = "androidx.compose.material:material-icons-extended:$version"
            const val runtime = "androidx.compose.runtime:runtime:$version"
            const val runtimeLivedata = "androidx.compose.runtime:runtime-livedata:$version"
            const val tooling = "androidx.ui:ui-tooling:$version"
        }

        object Lifecycle {
            private const val version = "2.2.0"
            const val extensions = "androidx.lifecycle:lifecycle-extensions:$version"
            const val livedata = "androidx.lifecycle:lifecycle-livedata-ktx:$version"
            const val viewmodel = "androidx.lifecycle:lifecycle-viewmodel-ktx:$version"
        }
    }

    object Ktor {
        private const val version = "1.4.0"
        const val core = "io.ktor:ktor-client-core:$version"
        const val android = "io.ktor:ktor-client-android:$version"
        const val json = "io.ktor:ktor-client-json:$version"
        const val serialization = "io.ktor:ktor-client-serialization:$version"
    }
}