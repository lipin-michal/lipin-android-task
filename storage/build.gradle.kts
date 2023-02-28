plugins {
	id("com.android.library")
	kotlin("kapt")
	kotlin("android")
}

android {
	compileSdk = 33
	buildToolsVersion = "33.0.2"

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

	implementation("io.insert-koin:koin-android:3.1.2")

	implementation("androidx.room:room-runtime:2.5.0")
	implementation("androidx.room:room-ktx:2.5.0")
	kapt("androidx.room:room-compiler:2.5.0")

	testImplementation("junit:junit:4.13.2")
}
