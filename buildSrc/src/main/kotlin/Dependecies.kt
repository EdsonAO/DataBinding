const val kotlinVersion = "1.3.72"
const val gradleVersion = "4.1.2"
const val hiltVersion = "2.33-beta"

object BuildPlugins {
    const val androidGradlePlugin = "com.android.tools.build:gradle:$gradleVersion"
    const val kotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion"
    const val hiltGradlePlugin = "com.google.dagger:hilt-android-gradle-plugin:$hiltVersion"
    const val androidApplication = "com.android.application"
    const val kotlinAndroid = "kotlin-android"
    const val kotlinKapt = "kotlin-kapt"
    const val daggerHilt = "dagger.hilt.android.plugin"
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
        const val paging = "2.1.2"
        const val activityKTX = "1.2.0"
        const val hiltX = "1.0.0-alpha03"
        const val navigation = "2.3.3"
        const val interceptor = "4.5.0"
        const val retrofit = "2.9.0"
        const val bindingAdapter = "4.0.0"
        const val bindingPaging = "3.1.1"
        const val glide = "4.12.0"
        const val palette = "2.1.2"
    }

    const val kotlin = "org.jetbrains.kotlin:kotlin-stdlib:${kotlinVersion}"
    const val appcompat = "androidx.appcompat:appcompat:${Versions.appcompat}"
    const val coreKTX = "androidx.core:core-ktx:${Versions.ktx}"
    const val materialUI = "com.google.android.material:material:${Versions.material}"
    const val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.constraint}"
    const val paging = "androidx.paging:paging-runtime-ktx:${Versions.paging}"
    const val activityKtx = "androidx.activity:activity-ktx:${Versions.activityKTX}"
    const val daggerHilt = "com.google.dagger:hilt-android:$hiltVersion"
    const val hiltCompiler = "com.google.dagger:hilt-android-compiler:$hiltVersion"
    const val hiltLifecycleX = "androidx.hilt:hilt-lifecycle-viewmodel:${Versions.hiltX}"
    const val hiltCompilerX = "androidx.hilt:hilt-compiler:${Versions.hiltX}"
    const val navigationX = "androidx.navigation:navigation-fragment-ktx:${Versions.navigation}"
    const val navigationUI = "androidx.navigation:navigation-ui-ktx:${Versions.navigation}"
    const val interceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.interceptor}"
    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val gson = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"
    const val glide = "com.github.bumptech.glide:glide:${Versions.glide}"
    const val glideCompiler = "com.github.bumptech.glide:compiler:${Versions.glide}"
    const val glidePalette = "com.github.florent37:glidepalette:${Versions.palette}"
    const val bindingAdapterCore = "me.tatarka.bindingcollectionadapter2:bindingcollectionadapter:${Versions.bindingAdapter}"
    const val bindingAdapterRecycler = "me.tatarka.bindingcollectionadapter2:bindingcollectionadapter-recyclerview:${Versions.bindingAdapter}"
    const val bindingAdapterPaging = "me.tatarka.bindingcollectionadapter2:bindingcollectionadapter-paging:${Versions.bindingPaging}"
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