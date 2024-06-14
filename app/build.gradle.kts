plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsKotlinAndroid)
    alias(libs.plugins.navigationArgs)
}

android {
    namespace = "com.saliev.geeksdelivery"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.saliev.geeksdelivery"
        minSdk = 26
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"
        buildConfigField("String","BASE_URL","\"https://www.themealdb.com/api/json/v1/1/\"")

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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures{
        viewBinding = true
        buildConfig = true
    }
}

dependencies {
    implementation(libs.bundles.ui.component)
    implementation(libs.bundles.test.component)
    //Retrofit
    implementation(libs.bundles.network.component)

    //Koin
    implementation(libs.bundles.koin.component)
    //OkHttp
    implementation(platform(libs.okhttp.bom))
    implementation(libs.okhttp)
    implementation(libs.logging.interceptor)
    //Nav Component
    implementation(libs.bundles.navigaion.component)


}