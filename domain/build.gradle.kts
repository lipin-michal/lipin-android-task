plugins {
	id("java-library")
	id("kotlin")
}

java {
	sourceCompatibility = JavaVersion.VERSION_1_8
	targetCompatibility = JavaVersion.VERSION_1_8
}

dependencies {
	implementation("org.jetbrains.kotlin:kotlin-stdlib:1.7.10")
	implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.4")
}