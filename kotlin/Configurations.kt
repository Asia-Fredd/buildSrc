@file:Suppress("PropertyName", "Unused")

object Versions {
    const val KOTLIN = "1.3.60"
    const val ANDROID_STUDIO_STABLE = "3.5.3"
    const val ANDROID_STUDIO_BETA   = "3.6.0-beta05"
    const val ANDROID_STUDIO_CANARY = "4.0.0-alpha06"
    const val ANDROID_MIN_VERSION   = 21
    const val ANDROID_SDK_VERSION   = 29
    const val ANDROID_BUILD_VERSION = "29.0.2"
}

object Configs {
    internal object Kotlin : Source(version = Versions.KOTLIN) {
        val GradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:$version"
        val StdLib  = "org.jetbrains.kotlin:kotlin-stdlib:$version"       // kotlin("stdlib")
        val StdLib7 = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:$version"  // kotlin("stdlib-jdk7")
        val StdLib8 = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:$version"  // kotlin("stdlib-jdk8")
        val TestJunit = "org.jetbrains.kotlin:kotlin-test-junit:$version" // kotlin("test-junit")
    }
    internal data class Android(private val v: String) : Source(version = v) {
        val GradleTools: String = "com.android.tools.build:gradle:$version"
    }
    val KotlinGradlePlugin = Kotlin.GradlePlugin
    val AndroidGradleTools = Android(Versions.ANDROID_STUDIO_STABLE).GradleTools
    val AndroidGradleTools_Beta = Android(Versions.ANDROID_STUDIO_BETA).GradleTools
    val AndroidGradleTools_Canary = Android(Versions.ANDROID_STUDIO_CANARY).GradleTools
}

object BuildScan : Source(version = "3.1") {
    const val ID = "com.gradle.build-scan"
    const val termsOfServiceUrl = "https://gradle.com/terms-of-service"
    const val termsOfServiceAgree = "yes"
}

object Libs {
    object Kotlin {
        val StdLib  = Configs.Kotlin.StdLib
        val StdLib7 = Configs.Kotlin.StdLib7
        val StdLib8 = Configs.Kotlin.StdLib8
        val TestJunit = Configs.Kotlin.TestJunit
    }
    object AndroidX : Source(version = "1.1.0") {

        val AppCompat = "androidx.appcompat:appcompat:$version"
        val Core_KTX  = "androidx.core:core-ktx:$version"

        const val ConstraintLayout = "androidx.constraintlayout:constraintlayout:1.1.3"
        const val Legacy = "androidx.legacy:legacy-support-v4:1.0.0"

        object Lifecycle : Source(version = "2.1.0") {
            val Extensions = "androidx.lifecycle:lifecycle-extensions:$version"
            val ViewModelKtx = "androidx.lifecycle:lifecycle-viewmodel-ktx:$version"
        }

        object Test {
            const val Runner = "androidx.test:runner:1.2.0"
            const val Espresso = "androidx.test.espresso:espresso-core:3.2.0"
        }
    }
}

open class Source(val version: String)