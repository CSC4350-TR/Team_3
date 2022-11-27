plugins {
    id("com.android.application")
    kotlin("android")
    id ("com.google.gms.google-services")
}

android {
    namespace = "com.aacd.posterday.android"
    compileSdk = 33
    defaultConfig {
        applicationId = "com.aacd.posterday.android"
        minSdk = 21
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.3.0"
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
}

dependencies {
    val lifecycle_version = "2.6.0-alpha03"
    val nav_version = "2.5.3"
    val compose_version = "1.2.1"
    implementation("androidx.appcompat:appcompat:1.4.1")
    implementation("com.google.android.material:material:1.4.+")
    implementation(project(":shared"))
    implementation ("androidx.compose.material:material-icons-extended:$compose_version")
    implementation("androidx.compose.ui:ui:1.2.1")
    implementation("androidx.compose.ui:ui-tooling:1.2.1")
    implementation("androidx.compose.ui:ui-tooling-preview:1.2.1")
    implementation("androidx.compose.foundation:foundation:1.2.1")
    implementation("androidx.compose.material:material:1.2.1")
    implementation("androidx.activity:activity-compose:1.6.1")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycle_version")
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:$lifecycle_version")
    implementation(platform("com.google.firebase:firebase-bom:31.0.2"))
    implementation("com.google.firebase:firebase-analytics-ktx")
    implementation("com.google.firebase:firebase-auth-ktx")
    implementation("com.google.firebase:firebase-firestore-ktx")
    implementation("androidx.navigation:navigation-compose:$nav_version")
}