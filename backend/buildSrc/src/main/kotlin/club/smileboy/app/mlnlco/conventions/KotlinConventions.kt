package club.smileboy.app.mlnlco.conventions

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile;

/**
 * @author FLJ
 * @date 2022/7/8
 * @time 17:13
 * @Description Kotlin 约定
 */
class KotlinConventions: Plugin<Project> {
    override fun apply(project: Project) {
        project.plugins.withId("org.jetbrains.kotlin.jvm") {
            project.tasks.named("kotlinCompile", KotlinCompile::class.java) {
                kotlinOptions.apiVersion = project.properties["kotlinVersion"].toString()
                kotlinOptions.jvmTarget = kotlinOptions.apiVersion.toString()
                kotlinOptions.allWarningsAsErrors = false
                val freeCompilerArgs: MutableList<String> = ArrayList(kotlinOptions.freeCompilerArgs)
                freeCompilerArgs.add("-Xsuppress-version-warnings")
                freeCompilerArgs.add("-Xjsr305=strict")
                kotlinOptions.freeCompilerArgs = freeCompilerArgs
            }
        }
    }
}