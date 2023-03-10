plugins {
	id("com.android.application")
	id("androidx.navigation.safeargs")
	kotlin("android")
	kotlin("android.extensions")
}

android {
	compileSdk = 33
	buildToolsVersion = "33.0.2"

	defaultConfig {
		minSdk = 19
		targetSdk = 33
		versionCode = 1
		versionName = "1.0"
		multiDexEnabled = true

		testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
	}

	buildTypes {
		getByName("release") {
			isMinifyEnabled = true
			proguardFiles(
				getDefaultProguardFile("proguard-android-optimize.txt"),
				"proguard-rules.pro"
			)
		}
	}
	compileOptions {
		isCoreLibraryDesugaringEnabled = true
		sourceCompatibility = JavaVersion.VERSION_1_8
		targetCompatibility = JavaVersion.VERSION_1_8
	}
	kotlinOptions {
		jvmTarget = "1.8"
	}
	buildFeatures {
		viewBinding = true
	}
}

dependencies {
	implementation(project(":storage"))
	implementation(project(":network"))
	implementation(project(":domain"))

	implementation("androidx.multidex:multidex:2.0.1")

	implementation("org.jetbrains.kotlin:kotlin-stdlib:1.7.10")
	implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.6.4")

	implementation("com.google.android.material:material:1.6.0")

	implementation("androidx.core:core-ktx:1.9.0")
	implementation("androidx.appcompat:appcompat:1.6.1")
	implementation("androidx.constraintlayout:constraintlayout:2.1.4")
	implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.5.1")
	implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.5.1")
	implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.5.1")

	implementation("io.insert-koin:koin-android:3.1.2")

	implementation("androidx.navigation:navigation-fragment-ktx:2.5.3")
	implementation("androidx.navigation:navigation-ui-ktx:2.5.3")

	coreLibraryDesugaring("com.android.tools:desugar_jdk_libs:1.0.9")

	testImplementation("junit:junit:4.13.2")

	androidTestImplementation("androidx.test.ext:junit:1.1.3")
	androidTestImplementation("androidx.test.espresso:espresso-core:3.4.0")
}