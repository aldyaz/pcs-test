plugins {
    alias(libs.plugins.aldyaz.android.library.base)
    kotlin("kapt")
}

android {
    namespace = "com.aldyaz.common.presentation"

    defaultConfig {
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
}

dependencies {

    implementation(project(":common:domain"))

    implementation(libs.androidx.core.ktx)
    implementation(libs.bundles.coroutines)
    implementation(libs.bundles.lifecycle)

    kapt(libs.lifecycle.compiler)

    testImplementation(libs.junit)

    androidTestImplementation(libs.androidx.junit)
}