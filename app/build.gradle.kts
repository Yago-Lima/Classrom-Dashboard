plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.yago_de_lima_franca.atividade_12_04_2025"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.yago_de_lima_franca.atividade_12_04_2025"
        minSdk = 34
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}

dependencies {
    implementation ("com.airbnb.android:lottie:4.2.2")
    implementation ("androidx.recyclerview:recyclerview:1.2.1")
    implementation("com.google.code.gson:gson:2.11.0")
    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
}