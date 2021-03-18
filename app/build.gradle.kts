plugins {
    id(BuildPlugins.androidApplication)
    id(BuildPlugins.kotlinAndroid)
    id(BuildPlugins.kotlinKapt)
    id(BuildPlugins.daggerHilt)
}

android {
    compileSdkVersion (AndroidSDK.compileSdk)

    buildFeatures {
        viewBinding = true
        dataBinding = true
    }

    defaultConfig {
        applicationId = DefaultConfig.applicationID
        minSdkVersion (DefaultConfig.minSdk)
        targetSdkVersion (DefaultConfig.targetSdk)
        versionCode = DefaultConfig.versionCode
        versionName = DefaultConfig.versionName
        testInstrumentationRunner = DefaultConfig.instrumentationRunner
    }

    buildTypes {
        getByName(BuildTypes.release) {
            isMinifyEnabled = false
            proguardFiles (getDefaultProguardFile(ProguardFile.textFile), ProguardFile.ruleFile)
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }

    kapt {
        correctErrorTypes = true
    }

    sourceSets {
        getByName("main") {
            java.srcDirs("src/main/kotlin")
        }
    }
}

dependencies {
    implementation(ApplicationLibs.kotlin)
    implementation(ApplicationLibs.coreKTX)
    implementation(ApplicationLibs.appcompat)
    implementation(ApplicationLibs.materialUI)
    implementation(ApplicationLibs.constraintLayout)
    implementation(ApplicationLibs.paging)
    /** Activity KTX for viewModels() **/
    implementation(ApplicationLibs.activityKtx)
    /** Dagger - Hilt **/
    implementation(ApplicationLibs.daggerHilt)
    kapt(ApplicationLibs.hiltCompiler)
    implementation(ApplicationLibs.hiltLifecycleX)
    kapt(ApplicationLibs.hiltCompilerX)
    /** Navigation **/
    implementation(ApplicationLibs.navigationX)
    implementation(ApplicationLibs.navigationUI)
    /** OkHttp Logging interceptor **/
    implementation(ApplicationLibs.interceptor)
    /** Retrofit 2 **/
    implementation(ApplicationLibs.retrofit)
    implementation(ApplicationLibs.gson)
    /** Binding Adapter Collection **/
    implementation(ApplicationLibs.bindingAdapterCore)
    implementation(ApplicationLibs.bindingAdapterRecycler)
    implementation(ApplicationLibs.bindingAdapterPaging)
    /** Glide **/
    implementation(ApplicationLibs.glide)
    implementation(ApplicationLibs.glidePalette)
    kapt(ApplicationLibs.glideCompiler)

    /** Test Libs **/
    testImplementation(TestLibs.junit)
    androidTestImplementation(TestLibs.extJunit)
    androidTestImplementation(TestLibs.espresso)
}