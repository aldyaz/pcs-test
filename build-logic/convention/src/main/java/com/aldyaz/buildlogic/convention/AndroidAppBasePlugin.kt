package com.aldyaz.buildlogic.convention

import com.android.build.gradle.BaseExtension
import org.gradle.api.Plugin
import org.gradle.api.Project

class AndroidAppBasePlugin : Plugin<Project> {

    override fun apply(target: Project) {
        target.run {
            plugins.apply("com.android.application")
            plugins.apply("org.jetbrains.kotlin.android")

            target.extensions.getByType(BaseExtension::class.java).apply {
                configureAndroidBaseVersion()
                configureCompileOptions()
            }
        }
    }
}