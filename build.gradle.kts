plugins {
    `kotlin-dsl`
}
repositories {
    // The org.jetbrains.kotlin.jvm plugin requires a repository
    // where to download the Kotlin compiler dependencies from.
    // Required since Gradle 4.10+.
    // https://proandroiddev.com/gradle-dependency-management-with-kotlin-94eed4df9a28#a296
    jcenter()
}
kotlinDslPluginOptions {
    experimentalWarning.set(false)
}
sourceSets["main"].withConvention(org.jetbrains.kotlin.gradle.plugin.KotlinSourceSet::class) {
    kotlin.srcDir("kotlin")
}