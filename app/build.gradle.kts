plugins {
    alias(libs.plugins.aldyaz.android.app.base)
    alias(libs.plugins.aldyaz.android.buildFeature)
    id("dagger.hilt.android.plugin")
    kotlin("plugin.serialization") version libs.versions.kotlin
    kotlin("kapt")
}

android {
    namespace = "com.aldyaz.pcstest"

    defaultConfig {
        applicationId = "com.aldyaz.pcstest"
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
}

kapt {
    correctErrorTypes = true
}

dependencies {

    implementation(project(":common:data"))
    implementation(project(":common:domain"))
    implementation(project(":common:presentation"))
    implementation(project(":common:ui"))

    implementation(project(":member:data"))
    implementation(project(":member:domain"))
    implementation(project(":member:presentation"))
    implementation(project(":member:ui"))

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)

    implementation(libs.bundles.coroutines)
    implementation(libs.bundles.networking)
    implementation(libs.bundles.compose)
    implementation(libs.bundles.lifecycle)
    implementation(libs.bundles.coil)

    implementation(libs.hilt.android)

    implementation(libs.kotlinx.serialization)

    kapt(libs.hilt.compiler)

    debugImplementation(libs.bundles.pluto)
    releaseImplementation(libs.bundles.pluto.noop)

    testImplementation(libs.junit)

    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}