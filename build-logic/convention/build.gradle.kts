import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    `kotlin-dsl`
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

kotlin {
    compilerOptions {
        jvmTarget = JvmTarget.JVM_17
    }
}

dependencies {
    compileOnly(libs.kotlinGradlePlugin)
    compileOnly(libs.androidBuildTools)
}

gradlePlugin {
    plugins {
        register("androidAppBase") {
            id = "aldyaz.android.app.base"
            implementationClass = "com.aldyaz.buildlogic.convention.AndroidAppBasePlugin"
        }
        register("androidLibraryBase") {
            id = "aldyaz.android.library.base"
            implementationClass = "com.aldyaz.buildlogic.convention.AndroidLibraryBasePlugin"
        }
        register("androidBuildFeature") {
            id = "aldyaz.android.buildFeature"
            implementationClass = "com.aldyaz.buildlogic.convention.AndroidBuildFeaturePlugin"
        }
    }
}
