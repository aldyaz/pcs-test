plugins {
    alias(libs.plugins.aldyaz.android.library.base)
    alias(libs.plugins.aldyaz.android.buildFeature)
}

android {
    namespace = "com.aldyaz.common.ui"

    defaultConfig {
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
}

dependencies {

    implementation(project(":common:presentation"))

    implementation(libs.androidx.core.ktx)
    implementation(libs.material)
    implementation(libs.bundles.compose)

    testImplementation(libs.junit)

    androidTestImplementation(libs.androidx.junit)
}