// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
	val kotlinVersion = "1.7.10"

	repositories {
		google()
		mavenCentral()
	}
	dependencies {
		classpath("com.android.tools.build:gradle:4.2.2")
		classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion")
		classpath("androidx.navigation:navigation-safe-args-gradle-plugin:2.5.3")
		// NOTE: Do not place your application dependencies here; they belong
		// in the individual module build.gradle.kts.kts files
	}
}

allprojects {
	repositories {
		google()
		mavenCentral()
	}
}

tasks.create<Delete>("clean") {
	delete = setOf(rootProject.buildDir)
}
