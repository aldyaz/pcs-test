plugins {
    alias(libs.plugins.aldyaz.android.library.base)
    alias(libs.plugins.ksp)
}

android {
    namespace = "com.aldyaz.datasource"

    defaultConfig {
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
}

dependencies {

    implementation(libs.bundles.networking)
    implementation(libs.bundles.coroutines)
    implementation(libs.hilt.android)

    ksp(libs.hilt.compiler)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
}