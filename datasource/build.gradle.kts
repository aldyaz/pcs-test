plugins {
    alias(libs.plugins.aldyaz.android.library.base)
    kotlin("kapt")
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

    constraints {
        implementation(libs.bundles.lifecycle) {
            because("using project version")
        }
    }

    debugImplementation(libs.bundles.pluto)
    releaseImplementation(libs.bundles.pluto.noop)

    kapt(libs.hilt.compiler)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
}