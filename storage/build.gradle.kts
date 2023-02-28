
plugins {
    id("com.android.library")
    kotlin("kapt")
    kotlin("android")
}

android {
    compileSdkVersion(33)
    buildToolsVersion = "30.0.3"

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

    implementation("io.insert-koin:koin-android:3.1.2")

    implementation("androidx.room:room-runtime:2.3.0")
    implementation("androidx.room:room-ktx:2.3.0")
    kapt("androidx.room:room-compiler:2.3.0")

    testImplementation("junit:junit:4.13.2")
}
