package com.aldyaz.buildlogic.convention

import com.android.build.gradle.BaseExtension
import org.gradle.api.Plugin
import org.gradle.api.Project

class AndroidBuildFeaturePlugin : Plugin<Project> {

    override fun apply(target: Project) {
        target.plugins.apply("org.jetbrains.kotlin.plugin.compose")
        target.extensions.getByType(BaseExtension::class.java).apply {
            buildFeatures.apply {
                viewBinding = true
                compose = true
            }
        }
    }
}