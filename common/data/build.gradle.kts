plugins {
    alias(libs.plugins.aldyaz.android.library.base)
}

android {
    namespace = "com.aldyaz.common.data"

    defaultConfig {
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
}

dependencies {

    api(project(":datasource"))
    implementation(project(":common:domain"))

    implementation(libs.androidx.core.ktx)

    testImplementation(libs.junit)

    androidTestImplementation(libs.androidx.junit)
}