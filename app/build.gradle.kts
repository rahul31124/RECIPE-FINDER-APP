plugins {

    id("com.android.application")
    id("org.jetbrains.kotlin.android")


    id ("kotlin-kapt")
    id("com.google.devtools.ksp") version "1.8.10-1.0.9" apply false
}

android {
    namespace = "com.example.mealrecipes"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.mealrecipes"
        minSdk = 28
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    android {

        buildFeatures {
            viewBinding = true
        }
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
}

dependencies {

    implementation("androidx.core:core-ktx:1.13.1")
    implementation("androidx.appcompat:appcompat:1.7.0")
    implementation("com.google.android.material:material:1.12.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("androidx.navigation:navigation-fragment-ktx:2.7.7")
    implementation("androidx.navigation:navigation-ui-ktx:2.7.7")
    implementation("com.android.car.ui:car-ui-lib:2.6.0")
    implementation("androidx.compose.animation:animation-core-android:1.6.8")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    implementation("com.airbnb.android:lottie:6.1.0")
    implementation("com.github.bumptech.glide:glide:4.12.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation("androidx.navigation:navigation-fragment-ktx:2.3.5")
    implementation( "androidx.navigation:navigation-ui-ktx:2.3.5")

    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    val room_version = "2.6.1"

    implementation("androidx.room:room-runtime:$room_version")
    annotationProcessor("androidx.room:room-compiler:$room_version")

    kapt("androidx.room:room-compiler:$room_version")

    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.6.1")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.1")

    implementation("androidx.room:room-ktx:$room_version")


    implementation("androidx.room:room-rxjava2:$room_version")


    implementation ("androidx.lifecycle:lifecycle-livedata-ktx:2.4.1")
    implementation ("androidx.lifecycle:lifecycle-viewmodel-ktx:2.4.1")

    implementation ("com.google.android.material:material:1.8.0")

    implementation("androidx.room:room-rxjava3:$room_version")

    implementation ("androidx.lifecycle:lifecycle-viewmodel-ktx:2.4.1")

    implementation ("androidx.work:work-runtime-ktx:2.7.1")

    implementation("androidx.room:room-guava:$room_version")

    implementation ("com.google.firebase:firebase-core:21.0.0") // or your current version

    implementation ("androidx.lifecycle:lifecycle-viewmodel-ktx:2.4.0")
    implementation ("androidx.lifecycle:lifecycle-livedata-ktx:2.4.0")
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.5.2")
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.5.2")


    implementation(platform("com.google.firebase:firebase-bom:33.3.0"))

    // Add the dependency for the Firebase ML model downloader library
    // When using the BoM, you don't specify versions in Firebase library dependencies
    implementation("com.google.firebase:firebase-ml-modeldownloader")

    // Also add the dependency for the TensorFlow Lite library and specify its version
    implementation("org.tensorflow:tensorflow-lite:2.3.0")

    implementation ("com.intuit.sdp:sdp-android:1.1.1")





    testImplementation("androidx.room:room-testing:$room_version")


    implementation("androidx.room:room-paging:$room_version")


}