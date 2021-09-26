plugins {
    id("com.android.application")
    kotlin("android")
}

dependencies {
    implementation(project(":shared"))
    implementation("com.google.android.material:material:1.3.0")
    implementation("androidx.appcompat:appcompat:1.2.0")
    implementation("androidx.constraintlayout:constraintlayout:2.0.4")
    implementation(Develop.multiplatformSettings)
    implementation(Develop.koinCore)
    implementation(Develop.koinAndroid)
    implementation(Develop.Ktor.androidCore)
    implementation(Develop.Coroutines.common)
    implementation(Develop.Coroutines.android)
    implementation(Develop.AndroidX.lifecycle_runtime)
    implementation(Develop.AndroidX.lifecycle_viewmodel)
    implementation(Develop.AndroidX.lifecycle_viewmodel_extensions)
}

android {
    compileSdkVersion(30)
    defaultConfig {
        applicationId = "com.officeyuli.kmmitexample.android"
        minSdkVersion(23)
        targetSdkVersion(30)
        versionCode = 1
        versionName = "1.0"
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
}