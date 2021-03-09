plugins {
    id(BuildPlugins.androidApplication)
    id(BuildPlugins.kotlinAndroid)
    id(BuildPlugins.kotlinAndroidExtensions)
}

android {
    compileSdkVersion (AndroidSDK.compileSdk)

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

    /** Test Libs **/
    testImplementation(TestLibs.junit)
    androidTestImplementation(TestLibs.extJunit)
    androidTestImplementation(TestLibs.espresso)
}