plugins {
    `kotlin-dsl`
}

dependencies {
    compileOnly(libs.kotlinGradlePlugin)
    compileOnly(libs.androidBuildTools)
}

gradlePlugin {
    plugins {
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
