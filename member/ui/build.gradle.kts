plugins {
    alias(libs.plugins.aldyaz.android.library.base)
    alias(libs.plugins.aldyaz.android.buildFeature)
    alias(libs.plugins.ksp)
}

android {
    namespace = "com.aldyaz.member.ui"

    defaultConfig {
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
}

dependencies {

    implementation(project(":common:ui"))
    implementation(project(":member:presentation"))

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.bundles.compose)
    implementation(libs.bundles.coil)
    implementation(libs.bundles.lifecycle)

    implementation(libs.hilt.android)
    ksp(libs.hilt.compiler)

    testImplementation(libs.junit)

    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}