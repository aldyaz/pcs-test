package com.aldyaz.buildlogic.convention

import com.android.build.gradle.BaseExtension
import org.gradle.api.JavaVersion

internal fun BaseExtension.configureAndroidBaseVersion() {
    compileSdkVersion(ApiLevelVersion.COMPILE_SDK)
    defaultConfig {
        minSdk = ApiLevelVersion.MIN_SDK
        targetSdk = ApiLevelVersion.TARGET_SDK
    }
}

internal fun BaseExtension.configureCompileOptions() {
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
}
