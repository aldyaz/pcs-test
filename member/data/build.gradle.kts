plugins {
    alias(libs.plugins.aldyaz.android.library.base)
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

    testImplementation(libs.junit)

    androidTestImplementation(libs.androidx.junit)
}