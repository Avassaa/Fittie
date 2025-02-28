import java.util.Properties


plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-parcelize")
    id("com.google.gms.google-services")
}

android {

    namespace = "com.example.fitnesstrackerandplanner"
    compileSdk = 34
    buildTypes {
        getByName("release") {
            val p = Properties()
            p.load(project.rootProject.file("local.properties").reader())
            val yourKey: String = p.getProperty("API_KEY")
            buildConfigField("String", "API_KEY", "\"$yourKey\"")
        }
        getByName("debug"){
            val p = Properties()
            p.load(project.rootProject.file("local.properties").reader())
            val yourKey: String = p.getProperty("API_KEY")
            buildConfigField("String", "API_KEY", "\"$yourKey\"")
        }

    }

    defaultConfig {
        applicationId = "com.example.fitnesstrackerandplanner"
        minSdk = 26
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"





        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
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
    buildFeatures {
        compose = true
        buildConfig=true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    implementation ("com.google.code.gson:gson:2.8.8")
    implementation("org.jetbrains.kotlin:kotlin-stdlib:1.8.0")

    implementation("com.google.firebase:firebase-database-ktx:21.0.0")
    implementation("androidx.media3:media3-exoplayer-smoothstreaming:1.3.1")
    implementation("androidx.media3:media3-ui:1.3.1")
    implementation("androidx.media3:media3-exoplayer:1.3.1")
    implementation("androidx.media3:media3-datasource:1.3.1")
    implementation("androidx.media3:media3-common:1.3.1")
    implementation ("androidx.health.connect:connect-client:1.0.0-alpha11")
    implementation ("com.pierfrancescosoffritti.androidyoutubeplayer:core:12.1.0")
    implementation ("com.pierfrancescosoffritti.androidyoutubeplayer:chromecast-sender:0.28")
    implementation ("com.squareup.retrofit2:retrofit:2.9.0")
    implementation ("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation ("com.squareup.okhttp3:okhttp:4.9.0")
    implementation ("com.squareup.okhttp3:logging-interceptor:4.9.0")
    implementation("androidx.test.ext:junit-ktx:1.1.5")
    implementation("androidx.compose.ui:ui-test-junit4-android:1.6.8")
    testImplementation("org.junit.jupiter:junit-jupiter:5.8.1")


    dependencies {
        implementation("androidx.sqlite:sqlite:2.1.0") //
        implementation(platform("com.google.firebase:firebase-bom:33.1.0"))
        implementation ("com.github.ozcanalasalvar.picker:wheelview:2.0.5")
        androidTestImplementation("androidx.compose.ui:ui-test-junit4:1.7.0-beta03")
        debugImplementation("androidx.compose.ui:ui-test-manifest:1.6.8")
        implementation("androidx.activity:activity-compose:1.9.0")
        implementation(platform("androidx.compose:compose-bom:2024.05.00"))
        implementation("androidx.compose.ui:ui")
        implementation("com.google.android.exoplayer:exoplayer-ui:2.19.1")
        implementation("androidx.compose.ui:ui-graphics")
        implementation("com.google.firebase:firebase-auth")
        testImplementation ("org.robolectric:robolectric:4.9.2")
        testImplementation("org.mockito:mockito-core:4.0.0")
        testImplementation("org.mockito:mockito-inline:4.0.0")
        implementation("com.google.firebase:firebase-firestore")
        implementation("androidx.compose.ui:ui-tooling-preview")
        implementation("androidx.compose.material3:material3")
        implementation("androidx.navigation:navigation-compose:2.7.7")
        implementation("androidx.core:core-splashscreen:1.0.1")
        implementation("androidx.core:core-ktx:1.13.1")
        implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.8.0")
        implementation("androidx.appcompat:appcompat:1.6.1")
        testImplementation("junit:junit:4.13.2")
        androidTestImplementation("androidx.test.ext:junit:1.1.5")
        androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
        androidTestImplementation(platform("androidx.compose:compose-bom:2023.08.00"))
        androidTestImplementation("androidx.compose.ui:ui-test-junit4")
        debugImplementation("androidx.compose.ui:ui-tooling")
        debugImplementation("androidx.compose.ui:ui-test-manifest")
    }

}
