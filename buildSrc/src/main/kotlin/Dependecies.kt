const val kotlinVersion = "1.3.72"
const val gradleVersion = "4.1.2"

object BuildPlugins {
    const val androidGradlePlugin = "com.android.tools.build:gradle:$gradleVersion"
    const val kotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion"
    const val androidApplication = "com.android.application"
    const val kotlinAndroid = "kotlin-android"
    const val kotlinAndroidExtensions = "kotlin-android-extensions"
}

object Tasks {
    const val taskTypeClean = "clean"
}

object AndroidSDK {
    const val compileSdk = 29
}

object DefaultConfig {
    const val applicationID = "com.app.edson"
    const val minSdk = 16
    const val targetSdk = 29
    const val versionCode = 1
    const val versionName = "1.0"
    const val instrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
}

object BuildTypes {
    const val release = "release"
}

object ProguardFile {
    const val textFile = "proguard-android-optimize.txt"
    const val ruleFile = "proguard-rules.pro"
}

object ApplicationLibs {
    private object Versions {
        const val appcompat = "1.2.0"
        const val ktx = "1.3.2"
        const val material = "1.3.0"
        const val constraint = "2.0.4"
    }

    const val kotlin = "org.jetbrains.kotlin:kotlin-stdlib:${kotlinVersion}"
    const val appcompat = "androidx.appcompat:appcompat:${Versions.appcompat}"
    const val coreKTX = "androidx.core:core-ktx:${Versions.ktx}"
    const val materialUI = "com.google.android.material:material:${Versions.material}"
    const val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.constraint}"
}

object TestLibs {
    private object Versions {
        const val junit = "4.13.2"
        const val extJunit = "1.1.2"
        const val espresso = "3.3.0"
    }

    const val junit = "junit:junit:${Versions.junit}"
    const val extJunit = "androidx.test.ext:junit:${Versions.extJunit}"
    const val espresso = "androidx.test.espresso:espresso-core:${Versions.espresso}"
}