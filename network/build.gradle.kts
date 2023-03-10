plugins {
	id("com.android.library")
	kotlin("android")
	kotlin("plugin.serialization") version "1.7.10"
}

android {
	compileSdk = 33

	defaultConfig {
		minSdk = 19
		targetSdk = 33
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

	implementation("org.jetbrains.kotlin:kotlin-stdlib:1.7.10")
	implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.2.1")

	implementation("io.insert-koin:koin-android:3.1.2")

	implementation("io.ktor:ktor-client-android:1.6.0")
	implementation("io.ktor:ktor-client-serialization:1.6.0")
	testImplementation("junit:junit:4.12")
}