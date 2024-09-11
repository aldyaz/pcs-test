package com.aldyaz.buildlogic.convention

import com.android.build.gradle.BaseExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.withType
import org.jetbrains.kotlin.gradle.dsl.KotlinVersion
import org.jetbrains.kotlin.gradle.tasks.KotlinJvmCompile

class AndroidLibraryBasePlugin : Plugin<Project> {

    override fun apply(target: Project) {
        target.configurePlugin()
        target.configureAndroid()
    }

    private fun Project.configurePlugin() {
        plugins.apply("com.android.library")
        plugins.apply("org.jetbrains.kotlin.android")
    }

    private fun Project.configureAndroid() {
        extensions.getByType(BaseExtension::class.java).apply {
            configureAndroidBaseVersion()
            configureCompileOptions()

            tasks.withType<KotlinJvmCompile>().configureEach {
                compilerOptions {
                    apiVersion.set(KotlinVersion.KOTLIN_2_0)
                }
            }
        }
    }
}