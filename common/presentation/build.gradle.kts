plugins {
    alias(libs.plugins.aldyaz.android.library.base)
    alias(libs.plugins.ksp)
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

    ksp(libs.lifecycle.compiler)

    testImplementation(libs.junit)

    androidTestImplementation(libs.androidx.junit)
}