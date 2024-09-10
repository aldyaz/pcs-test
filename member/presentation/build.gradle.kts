plugins {
    alias(libs.plugins.aldyaz.android.library.base)
    alias(libs.plugins.ksp)
}

android {
    namespace = "com.aldyaz.member.presentation"

    defaultConfig {
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
}

dependencies {

    api(project(":common:presentation"))
    implementation(project(":member:domain"))

    implementation(libs.androidx.core.ktx)
    implementation(libs.hilt.android)

    ksp(libs.hilt.compiler)

    testImplementation(libs.junit)

    androidTestImplementation(libs.androidx.junit)
}