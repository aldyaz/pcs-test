plugins {
    alias(libs.plugins.aldyaz.android.library.base)
    alias(libs.plugins.ksp)
}

android {
    namespace = "com.aldyaz.member.data"

    defaultConfig {
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
}

dependencies {

    implementation(project(":common:data"))
    implementation(project(":member:domain"))

    implementation(libs.androidx.core.ktx)
    implementation(libs.hilt.android)

    ksp(libs.hilt.compiler)

    testImplementation(libs.junit)

    androidTestImplementation(libs.androidx.junit)
}