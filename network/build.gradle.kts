plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("plugin.serialization") version "1.5.0"
}

android {
    compileSdkVersion(33)

    defaultConfig {
        minSdkVersion(19)
        targetSdkVersion(33)
        versionCode = 1
        versionName = "1.0"
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    implementation(project(":domain"))

    implementation("org.jetbrains.kotlin:kotlin-stdlib:1.5.21")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.2.1")

    implementation("io.insert-koin:koin-android:3.1.2")

    implementation("io.ktor:ktor-client-android:1.6.0")
    implementation("io.ktor:ktor-client-serialization:1.6.0")
}